package Practicando.Finales;

import TP4.EJ1.Arco;
import TP4.EJ1.GrafoNoDirigido;

import java.util.*;

public class CicloEuleriano {
    private List<Arco> solucion;
    private GrafoNoDirigido<String> grafo;
    private Set<Arco> arcosVisitados;

    public CicloEuleriano(GrafoNoDirigido<String> grafo) {
        this.grafo = grafo;
        this.solucion = new ArrayList<>();
        this.arcosVisitados = new HashSet<>();
    }

    public List<Arco> back(String origen) {
        return back(origen, 0);
    }

    private List<Arco> back(String origen, Integer cantArcos) {
        if (cantArcos == grafo.cantidadArcos())
            return solucion;
        else {
            Iterator<String> itAdy = grafo.obtenerAdyacentes(origen);
            while (itAdy.hasNext()) {
                String next = itAdy.next();
                Arco arco = grafo.obtenerArco(origen, next);
                Arco arcoVuelta = grafo.obtenerArco(next, origen);
                if (!arcosVisitados.contains(arco) && !arcosVisitados.contains(arcoVuelta)) {
                    solucion.add(arco);
                    arcosVisitados.add(arco);
                    arcosVisitados.add(arcoVuelta);
                    solucion = back(next, cantArcos += 1);
                    if (solucion != null)
                        return solucion;
                    solucion.remove(arco);
                    arcosVisitados.remove(arco);
                    arcosVisitados.remove(arcoVuelta);
                }
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        GrafoNoDirigido<String> grafo = new GrafoNoDirigido<>();
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");

        grafo.agregarArco("A", "B", " ");
        grafo.agregarArco("A", "E", " ");
        grafo.agregarArco("A", "D", " ");
        grafo.agregarArco("B", "C", " ");
        grafo.agregarArco("C", "D", " ");
        grafo.agregarArco("D", "E", " ");

        CicloEuleriano ce = new CicloEuleriano(grafo);
        System.out.println(ce.back("A"));
    }
}
