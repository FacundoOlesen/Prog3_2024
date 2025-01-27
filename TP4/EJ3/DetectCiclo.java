package TP4.EJ3;

import TP4.EJ1.Grafo;

import java.util.HashMap;
import java.util.Iterator;

public class DetectCiclo {
    private static final String BLANCO = "BLANCO";
    private static final String AMARILLO = "AMARILLO";
    private static final String NEGRO = "NEGRO";
    private HashMap<Integer, String> vColores;

    public DetectCiclo() {
        this.vColores = new HashMap<>();
    }

    public boolean DFS(Grafo<Integer> grafo) {
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext())
            vColores.put(itVertices.next(), BLANCO);
        itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            int next = itVertices.next();
            if (DFS_Visit(grafo, next))
                return true;
        }
        return false;
    }


    private boolean DFS_Visit(Grafo<Integer> grafo, Integer vertice) {
        vColores.put(vertice, AMARILLO);
        Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(vertice);

        while (itAdyacentes.hasNext()) {
            int next = itAdyacentes.next();
            if (vColores.get(next) == BLANCO) {
                return DFS_Visit(grafo, next);
            } else if (vColores.get(next) == AMARILLO) {
                return true;
            }
        }

        vColores.put(vertice, NEGRO);
        return false;
    }
}
