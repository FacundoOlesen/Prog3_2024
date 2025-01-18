package TP6.EJ4;

import TP4.EJ1.GrafoDirigido;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido<Integer> grafito = new GrafoDirigido<>();
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(3);
        grafito.agregarVertice(4);
        grafito.agregarVertice(5);

        grafito.agregarArco(1, 2, 10);
        grafito.agregarArco(1, 5, 100);
        grafito.agregarArco(1, 4, 30);
        grafito.agregarArco(2, 3, 50);
        grafito.agregarArco(4, 5, 60);
        grafito.agregarArco(4, 3, 20);
        grafito.agregarArco(3, 5, 10);

        Dijkstra d = new Dijkstra(grafito);
        d.doDijkstra(1);
    }
}
