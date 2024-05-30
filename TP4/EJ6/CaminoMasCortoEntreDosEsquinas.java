package TP4.EJ6;

import TP4.EJ1.GrafoDirigido;
import TP4.EJ1.GrafoNoDirigido;

import java.util.*;

public class CaminoMasCortoEntreDosEsquinas {
    private Set<Integer> visitados;
    private Queue<Integer> colaVertices;
    private GrafoNoDirigido<?> grafo;


    public CaminoMasCortoEntreDosEsquinas(GrafoNoDirigido<?> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
        this.colaVertices = new LinkedList<>();
    }

    public List<Integer> obtenerCaminoMasCortoEntreDosEsquinas(Integer origen, Integer destino) {
        colaVertices.clear();

        List<Integer> solucionParcial = new ArrayList<>();
        visitados.add(origen);

        return asignarPadresEHijos(origen, destino);
    }

    private List<Integer> asignarPadresEHijos(Integer origen, Integer destino) {
        HashMap<Integer, Integer> padreHijo = new HashMap<>();
        visitados.add(origen);
        colaVertices.add(origen);
        while (!colaVertices.isEmpty()) {
            int primerElem = colaVertices.remove();
            Iterator<Integer> itAdyacentesAElem = this.grafo.obtenerAdyacentes(primerElem);
            while (itAdyacentesAElem.hasNext()) {
                Integer next = itAdyacentesAElem.next();
                if (!visitados.contains(next))
                    padreHijo.put(next, primerElem);
                if (next == destino) {
                    return reconstruirCamino(padreHijo, next);
                }
                if (!visitados.contains(next)) {
                    visitados.add(next);
                    colaVertices.add(next);
                }
            }
        }
        return new ArrayList<>();
    }

    private List<Integer> reconstruirCamino(HashMap<Integer, Integer> padres, Integer destino) {
        LinkedList<Integer> salida = new LinkedList<>();
        Integer actual = destino;
        while (actual != null) {
            salida.add(0, actual);
            actual = padres.get(actual);
        }
        return salida;
    }
}