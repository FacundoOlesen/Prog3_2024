package TP4.EJ5;

import TP4.EJ1.GrafoDirigido;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido<Integer> grafito = new GrafoDirigido<>();
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(4);
        grafito.agregarVertice(3);
        grafito.agregarVertice(5);
        grafito.agregarVertice(6);
        grafito.agregarVertice(7);



        grafito.agregarArco(1, 2, 1);
        grafito.agregarArco(2, 4, 2);
        grafito.agregarArco(1, 3, 3);
        grafito.agregarArco(3, 5, 4);
        grafito.agregarArco(1, 6, 5);
        grafito.agregarArco(6, 7, 6);
        grafito.agregarArco(7, 5, 7);
        //grafito.agregarArco(5, 5, 7);

        //grafito.agregarArco(2, 5, 7);

        //grafito.agregarArco(4, 1, 71);


        VerticesTerminanEnV v = new VerticesTerminanEnV(grafito);
        System.out.println(v.getVerticesTerminanEnV(2));
    }
}