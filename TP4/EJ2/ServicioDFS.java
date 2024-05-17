package TP4.EJ2;

import TP4.EJ1.Grafo;

import java.util.HashMap;
import java.util.Iterator;

public class ServicioDFS {
    private static final String BLANCO = "BLANCO";
    private static final String AMARILLO = "AMARILLO";
    private static final String NEGRO = "NEGRO";
    private HashMap<Integer, String> verticesColores;

    public ServicioDFS() {
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

    private void DFS_Visit(Grafo<Integer> grafo, Integer vertice) {
        verticesColores.put(vertice, AMARILLO);
        Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(vertice);
        while (itAdyacentes.hasNext()) {
            int next = itAdyacentes.next();
            if (verticesColores.get(next) == BLANCO)  //ARCO TREE
                DFS_Visit(grafo, next);
            else if (verticesColores.get(next) == AMARILLO) { //ARCO BACK
                System.out.println("Arco Back! (Hay un ciclo)"); //EJ 3
            }
        }
        verticesColores.put(vertice, NEGRO);
    }
}
