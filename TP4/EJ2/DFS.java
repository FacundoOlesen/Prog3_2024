package TP4.EJ2;

import TP4.EJ1.Grafo;
import TP4.EJ1.GrafoDirigido;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DFS {
    private Grafo<Integer> grafo;
    private static final String BLANCO = "BLANCO";
    private static final String AMARILLO = "AMARILLO";
    private static final String NEGRO = "NEGRO";
    private HashMap<Integer, String> verticesColores;

    public DFS() {
        this.verticesColores = new HashMap<>();
    }

    public void DFS(Grafo<Integer> grafo) {
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            verticesColores.put(itVertices.next(), BLANCO);
        }
        Iterator<Integer> itVertices2 = grafo.obtenerVertices();
        while (itVertices2.hasNext()) {
            int next = itVertices2.next();
            if (verticesColores.get(next) == BLANCO) {
                DFS_Visit(grafo, next);
            }
        }

    }

    public void DFS_Visit(Grafo<Integer> grafo, Integer vertice) {
        verticesColores.put(vertice, AMARILLO);
        Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(vertice);
        while (itAdyacentes.hasNext()) {
            int next = itAdyacentes.next();
            if (verticesColores.get(next) == BLANCO)
                DFS_Visit(grafo, next);
        }
        verticesColores.put(vertice, NEGRO);
    }
}
