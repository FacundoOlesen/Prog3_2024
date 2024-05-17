package TP4.EJ5;

import TP4.EJ1.Arco;
import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class VerticesTerminanEnV {
    private GrafoDirigido<?> grafo;
    private Set<Integer> visitados;

    public VerticesTerminanEnV(GrafoDirigido<?> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
    }

    public List<Integer> verticesTerminanEnV(int v) {
        List<Integer> resultado = new ArrayList<>();
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        visitados.add(v);
        while (itVertices.hasNext()) {
            int next = itVertices.next();
            verticesTerminanEnV(next);  //ACA SE ROMPE EL ITERADOR PREGUNTAR
        }
        return resultado;
    }

    public void hola() {
        for (Integer vertice : visitados)
            System.out.println(vertice);
    }
}
