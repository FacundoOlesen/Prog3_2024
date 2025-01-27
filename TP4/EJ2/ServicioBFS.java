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
        colaVertices.clear();

        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            int next = itVertices.next();
            if (!visitados.contains(next))
                BFS(grafo, next);
        }
    }

    private void BFS(Grafo<Integer> grafo, Integer vertice) {
        visitados.add(vertice);
        colaVertices.add(vertice);
        while (!colaVertices.isEmpty()) {
            int next = colaVertices.remove();
            Iterator<Integer> itAdy = grafo.obtenerAdyacentes(next);
            while (itAdy.hasNext()) {
                int ady = itAdy.next();
                if (!visitados.contains(ady)) {
                    visitados.add(ady);
                    colaVertices.add(ady);
                }
            }
        }
    }
}
