package TP4.EJ2;

import TP4.EJ1.Grafo;

import java.util.*;

public class ServicioBFS {
    private Set<Integer> visitados;
    private Queue<Integer> colaVertices;


    public ServicioBFS() {
        this.visitados = new HashSet<>();
        this.colaVertices = new LinkedList<>();
    }

    public void BFS(Grafo<Integer> grafo) {
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        colaVertices.clear();
        while (itVertices.hasNext())
            visitados.add(itVertices.next());

        Iterator<Integer> itVertices2 = grafo.obtenerVertices();
        while (itVertices2.hasNext()) {
            int next = itVertices2.next();
            if (!visitados.contains(next))
                BFS(grafo, next);
        }
    }

    private void BFS(Grafo<Integer> grafo, Integer actual) {
        visitados.add(actual);
        colaVertices.add(actual);
        while (!colaVertices.isEmpty()) {
            int primerElem = colaVertices.remove();
            Iterator<Integer> itAdyacentesAElem = grafo.obtenerAdyacentes(primerElem);
            while (itAdyacentesAElem.hasNext()) {
                int next = itAdyacentesAElem.next();
                if (!visitados.contains(next)) {
                    visitados.add(next);
                    colaVertices.add(next);
                }
            }
        }
    }
}
