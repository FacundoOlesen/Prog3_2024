package TP4.EJ2;

import TP4.EJ1.Grafo;

import java.util.*;

public class ServicioBFS {
    private HashMap<Integer, String> visitaVertices;
    private Queue<Integer> colaVertices;
    private static final String VISITADO = "VISITADO";
    private static final String NO_VISITADO = "NO_VISITADO";

    public ServicioBFS() {
        this.visitaVertices = new HashMap<>();
        this.colaVertices = new LinkedList<>();
    }

    public ServicioBFS(Grafo<Integer> grafo) {
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        colaVertices.clear();
        while (itVertices.hasNext())
            visitaVertices.put(itVertices.next(), NO_VISITADO);

        Iterator<Integer> itVertices2 = grafo.obtenerVertices();
        while (itVertices2.hasNext()) {
            int next = itVertices2.next();
            if (visitaVertices.get(next) == NO_VISITADO)
                BFS(grafo, next);
        }
    }

    private void BFS(Grafo<Integer> grafo, Integer vertice) {
        visitaVertices.put(vertice, VISITADO);
        colaVertices.add(vertice);
        while (!colaVertices.isEmpty()) {
            int primerElem = colaVertices.remove();
            Iterator<Integer> itAdyacentesAElem = grafo.obtenerAdyacentes(primerElem);
            while (itAdyacentesAElem.hasNext()) {
                int next = itAdyacentesAElem.next();
                if (visitaVertices.get(next) == NO_VISITADO) {
                    visitaVertices.put(next, VISITADO);
                    colaVertices.add(next);
                }
            }
        }
    }
}
