package TP4.EJ2;

import TP4.EJ1.GrafoDirigido;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido<Integer> grafito = new GrafoDirigido<>();
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);

        // Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
        grafito.agregarArco(1, 2, 3);
        ServicioDFS dfs = new ServicioDFS();
        dfs.DFS(grafito);
    }
}
