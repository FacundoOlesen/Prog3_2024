package TP6.EJ8;

import TP4.EJ1.GrafoDirigido;
import TP4.EJ1.GrafoNoDirigido;

public class Main {

    public static void main(String[] args) {
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);

        grafo.agregarArco(1,2, 2);
        grafo.agregarArco(1,3, 2);

        ColoreoGrafo cg = new ColoreoGrafo(grafo);
        System.out.println(cg.colorear());
    }
}
