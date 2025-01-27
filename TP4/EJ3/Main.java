package TP4.EJ3;

import TP4.EJ1.GrafoDirigido;
import TP4.EJ2.ServicioBFS;
import TP4.EJ2.ServicioDFS;

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
        grafito.agregarVertice(15);
        grafito.agregarVertice(22);


        grafito.agregarArco(1, 2, 1);
        grafito.agregarArco(2, 4, 2);

        grafito.agregarArco(1, 3, 7);
        grafito.agregarArco(1, 6, 5);

        grafito.agregarArco(3, 5, 4);

        grafito.agregarArco(6, 7, 6);

        grafito.agregarArco(7, 6, 6);


        grafito.agregarArco(15, 22, 7);
        grafito.agregarArco(22, 15, 7);


        DetectCiclo d = new DetectCiclo();
        System.out.println(d.DFS(grafito));

    }
}
