package Practicando.Finales;

import TP4.EJ1.Arco;
import TP4.EJ1.GrafoNoDirigido;

import java.util.*;

public class EstacionesCiudades {
    private GrafoNoDirigido<Integer> grafoTuneles;
    private Set<Integer> visitados;
    private Set<Arco<Integer>> tunelesNoDisp;
    private List<Arco<Integer>> solucion;

    public EstacionesCiudades(GrafoNoDirigido<Integer> grafoTuneles) {
        this.grafoTuneles = grafoTuneles;
        this.visitados = new HashSet<>();
        this.solucion = new ArrayList<>();
        this.tunelesNoDisp = new HashSet<>();
    }

    public List<Arco<Integer>> greedy() {
        while (!solucion()) {
            Arco<Integer> tunel = seleccionar();
            tunelesNoDisp.add(tunel);
            if (tunel == null)
                return null;
            if (factible(tunel)) {
                solucion.add(tunel);
            }
        }
        return solucion;
    }


    private boolean solucion() {
        Iterator<Integer> itVertices = grafoTuneles.obtenerVertices();
        while (itVertices.hasNext()) {
            Integer next = itVertices.next();
            if (!estaEnSolucion(next))
                return false;
        }
        return true;
    }

    private boolean estaEnSolucion(Integer act) {
        for (Arco<Integer> arco : solucion) {
            if (arco.getVerticeOrigen() == act || arco.getVerticeDestino() == act)
                return true;
        }
        return false;
    }

    private Arco<Integer> seleccionar() {
        Iterator<Arco<Integer>> itArcos = grafoTuneles.obtenerArcos();
        Arco<Integer> mejor = null;
        while (itArcos.hasNext()) {
            Arco<Integer> next = itArcos.next();
            if (!tunelesNoDisp.contains(next)) {
                if (mejor == null || next.getEtiqueta() < mejor.getEtiqueta())
                    mejor = next;
            }
        }
        return mejor;
    }

    private GrafoNoDirigido<Integer> clonarGrafoConSolucion() {
        GrafoNoDirigido<Integer> grafoAux = new GrafoNoDirigido<>();
        for (Arco<Integer> arco : solucion) {
            grafoAux.agregarArco(arco.getVerticeOrigen(), arco.getVerticeDestino(), arco.getEtiqueta());
        }
        return grafoAux;
    }

    private boolean factible(Arco<Integer> tunel) {
        GrafoNoDirigido<Integer> grafoAux = clonarGrafoConSolucion();
        grafoAux.agregarArco(tunel.getVerticeOrigen(), tunel.getVerticeDestino(), tunel.getEtiqueta());
        Iterator<Integer> itVertices = grafoTuneles.obtenerVertices();
        while (itVertices.hasNext()) {
            Integer next = itVertices.next();
            if (!visitados.contains(next))
                if (!detectCiclo(grafoAux, next, null))
                    return true;
        }
        return false;
    }


    private boolean detectCiclo(GrafoNoDirigido<Integer> grafoAux, Integer act, Integer padre) {
        visitados.add(act);
        Iterator<Integer> itAdy = grafoAux.obtenerAdyacentes(act);
        while (itAdy.hasNext()) {
            Integer next = itAdy.next();
            if (!visitados.contains(next)) {
                if (detectCiclo(grafoAux, next, act))
                    return true;
            } else if (!next.equals(padre) && visitados.contains(next))
                return true;
        }
        visitados.remove(act);
        return false;
    }


    public static void main(String[] args) {
        GrafoNoDirigido<Integer> grafo3 = new GrafoNoDirigido<>();
        grafo3.agregarVertice(1);
        grafo3.agregarVertice(2);
        grafo3.agregarVertice(3);
        grafo3.agregarVertice(4);


        grafo3.agregarArco(1, 2, 1);
        grafo3.agregarArco(3, 4, 122);
        grafo3.agregarArco(2, 4, 1);
        grafo3.agregarArco(4, 3, 1);

        EstacionesCiudades c = new EstacionesCiudades(grafo3);
        System.out.println(c.greedy());
        System.out.println("");

    }
}
