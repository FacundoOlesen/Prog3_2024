package TP6.EJ6;

import TP4.EJ1.GrafoDirigido;
import TP4.EJ1.GrafoNoDirigido;

public class Main {
    public static void main(String[] args) {

        GrafoNoDirigido<Integer> grafito = new GrafoNoDirigido<>();
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(3);
        grafito.agregarVertice(4);
        grafito.agregarVertice(5);
        grafito.agregarVertice(6);


        grafito.agregarArco(1, 2, 3);
        grafito.agregarArco(1, 3, 10);
        grafito.agregarArco(1, 4, 11);
        grafito.agregarArco(1, 5, 7);
        grafito.agregarArco(1, 6, 25);

        grafito.agregarArco(2, 1, 3);
        grafito.agregarArco(2, 3, 8);
        grafito.agregarArco(2, 4, 12);
        grafito.agregarArco(2, 5, 9);
        grafito.agregarArco(2, 6, 26);

        grafito.agregarArco(3, 1, 10);
        grafito.agregarArco(3, 2, 8);
        grafito.agregarArco(3, 4, 9);
        grafito.agregarArco(3, 5, 4);
        grafito.agregarArco(3, 6, 20);

        grafito.agregarArco(4, 1, 11);
        grafito.agregarArco(4, 2, 12);
        grafito.agregarArco(4, 3, 9);
        grafito.agregarArco(4, 5, 5);
        grafito.agregarArco(4, 6, 15);

        grafito.agregarArco(5, 1, 7);
        grafito.agregarArco(5, 2, 9);
        grafito.agregarArco(5, 3, 4);
        grafito.agregarArco(5, 4, 5);
        grafito.agregarArco(5, 6, 18);

        grafito.agregarArco(6, 1, 25);
        grafito.agregarArco(6, 2, 26);
        grafito.agregarArco(6, 3, 20);
        grafito.agregarArco(6, 4, 15);
        grafito.agregarArco(6, 5, 18);

        TSP tsp = new TSP(grafito);

        System.out.println(tsp.TSP(1));

    }
}
