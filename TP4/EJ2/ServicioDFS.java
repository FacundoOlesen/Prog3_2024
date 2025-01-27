package TP4.EJ2;

import TP4.EJ1.Grafo;

import java.util.HashMap;
import java.util.Iterator;

public class ServicioDFS {
    private static final String BLANCO = "BLANCO";
    private static final String AMARILLO = "AMARILLO";
    private static final String NEGRO = "NEGRO";
    private HashMap<Integer, String> vColores;

    public ServicioDFS() {
        this.vColores = new HashMap<>();
    }

    public void DFS(Grafo<Integer> grafo) {
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext())
            vColores.put(itVertices.next(), BLANCO);

        itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            int next = itVertices.next();
            if (vColores.get(next) == BLANCO)
                DFS_Visit(grafo, next);
        }
    }

    private void DFS_Visit(Grafo<Integer> grafo, Integer vertice) {
        vColores.put(vertice, AMARILLO);
        Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(vertice);
        while (itAdyacentes.hasNext()) {
            int next = itAdyacentes.next();

            if (vColores.get(next) == BLANCO)  //ARCO TREE
                DFS_Visit(grafo, next);
        }
        vColores.put(vertice, NEGRO);
    }
}
