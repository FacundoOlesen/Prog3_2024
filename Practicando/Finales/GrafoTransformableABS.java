package Practicando.Finales;

import TP4.EJ1.GrafoDirigido;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GrafoTransformableABS {
    private static final String BLANCO = "BLANCO";
    private static final String AMARILLO = "AMARILLO";
    private static final String NEGRO = "NEGRO";
    private GrafoDirigido<Integer> grafo;
    private HashMap<Integer, String> verticeColores;
    private HashMap<Integer, Integer> padreHijo;


    public GrafoTransformableABS(GrafoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.verticeColores = new HashMap<>();
        this.padreHijo = new HashMap<>();
    }

    //Arbol Binario: Cada nodo no tiene mas 2 de hijos y desde la raiz deberia poder visitar todos los nodos.
    //El grafo debería ser aciclico.
    public boolean grafoEsArbolBinario(Integer V) {
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext())
            verticeColores.put(itVertices.next(), BLANCO);
        if (!DFS_Visit(V))
            return false;
        return todosVisitados();
    }

    private boolean DFS_Visit(Integer v) {
        verticeColores.put(v, AMARILLO);
        Iterator<Integer> itAdy = grafo.obtenerAdyacentes(v);
        while (itAdy.hasNext()) {
            Integer next = itAdy.next();
            if (verticeColores.get(next) == BLANCO) {
                padreHijo.put(v, padreHijo.getOrDefault(v, 0) + 1);
                DFS_Visit(next);
            }

            if (verticeColores.get(next) == AMARILLO)
                return false;

            if (padreHijo.get(v) > 2)
                return false;
        }
        verticeColores.put(v, NEGRO);
        return true;
    }

    private boolean todosVisitados() {
        for (Integer i : verticeColores.keySet()) {
            if (verticeColores.get(i) == AMARILLO || verticeColores.get(i) == BLANCO)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        // Crear un grafo dirigido
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        grafo.agregarArco(1, 2, 0);
        grafo.agregarArco(2, 3, 0);
        grafo.agregarArco(2, 4, 0);

        GrafoTransformableABS GrafoTransformableABS = new GrafoTransformableABS(grafo);

        System.out.println(GrafoTransformableABS.grafoEsArbolBinario(1));
    }
}
