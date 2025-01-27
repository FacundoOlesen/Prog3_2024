package TP4.EJ2;

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
        grafito.agregarVertice(15);
        grafito.agregarVertice(22);


        grafito.agregarArco(1, 2, 1);
        grafito.agregarArco(2, 4, 2);
        grafito.agregarArco(1, 3, 3);
        grafito.agregarArco(3, 5, 4);
        grafito.agregarArco(1, 6, 5);
        grafito.agregarArco(6, 7, 6);
        grafito.agregarArco(7, 5, 7);
        ServicioDFS dfs = new ServicioDFS();
         dfs.DFS(grafito);
        ServicioBFS bfs = new ServicioBFS();
        bfs.BFS(grafito);

    }
}
