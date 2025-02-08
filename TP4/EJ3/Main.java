package TP4.EJ3;

import TP4.EJ1.GrafoDirigido;
import TP4.EJ1.GrafoNoDirigido;
import TP4.EJ2.ServicioBFS;
import TP4.EJ2.ServicioDFS;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido<Integer> grafito = new GrafoDirigido<>();
        grafito.agregarVertice(5);
        grafito.agregarVertice(6);
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(4);


        grafito.agregarArco(5, 6, 2);
        grafito.agregarArco(6, 5, 2);

        grafito.agregarArco(1, 2, 1);
        grafito.agregarArco(2, 4, 2);
        grafito.agregarArco(4, 1, 2);


        DetectCiclo d = new DetectCiclo();
        System.out.println(d.DFS(grafito));

    }
}
