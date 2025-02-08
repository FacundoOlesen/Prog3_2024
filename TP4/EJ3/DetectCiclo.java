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
            if (vColores.get(next) == BLANCO) {
                if (DFS_Visit(grafo, null, next)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean DFS_Visit(Grafo<Integer> grafo, Integer padre, Integer act) {
        vColores.put(act, AMARILLO);
        Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(act);

        while (itAdyacentes.hasNext()) {
            Integer next = itAdyacentes.next();
            if (vColores.get(next) == BLANCO) {
                if (DFS_Visit(grafo, act, next))
                    return true;
            } else if (!next.equals(padre) && vColores.get(next) == AMARILLO) {
                return true;
            }
        }
        vColores.put(act, NEGRO);
        return false;
    }
}
