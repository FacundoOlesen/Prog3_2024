package TP6.EJ4;

import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class Dijkstra {
    private GrafoDirigido<Integer> grafo;
    private HashMap<Integer, Integer> dist;
    private HashMap<Integer, Integer> padre;
    private LinkedList<Integer> calculados;

    public Dijkstra() {
        this.grafo = new GrafoDirigido<>();
        this.dist = new HashMap<>();
        this.padre = new HashMap<>();
        this.calculados = new LinkedList<>();
    }

    public HashMap<Integer, Integer> dijkstra(Integer vertice) {
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            Integer v = itVertices.next();
            dist.put(v, Integer.MAX_VALUE);
            padre.put(v, Integer.MAX_VALUE);
        }

        dist.put(vertice, 0);

        Iterator<Integer> itVertices2 = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            Integer u = getMenor();
            calculados.add(u);
        }


        return padre;
    }

    public Integer getMenor() {
        Iterator<Integer> itDist = dist.values().iterator();
        Integer menor = Integer.MAX_VALUE;
        while (itDist.hasNext()) {
            Integer i = itDist.next();
            if (i < menor && !calculados.contains(i))
                menor = i;
        }
        return menor;
    }
}


