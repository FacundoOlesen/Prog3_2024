package Practicando.Finales;

import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class GrafoCiclicoSuma {
    private GrafoDirigido<Integer> grafo;
    private List<Integer> visitados;

    public GrafoCiclicoSuma(GrafoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.visitados = new ArrayList<>();
    }

    public boolean DFS_Ciclo(Integer X) {
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            Integer next = itVertices.next();
            if (!visitados.contains(next)) {
                if (DFS_Visit(next, X))
                    return true;
            }

        }
        return false;
    }

    private boolean DFS_Visit(Integer act, Integer X) {
        visitados.add(act);
        Iterator<Integer> itAdy = grafo.obtenerAdyacentes(act);
        while (itAdy.hasNext()) {
            Integer next = itAdy.next();
            if (!visitados.contains(next)) {
                return DFS_Visit(next, X);
            } else {
                List<Integer> ciclo = new ArrayList<>(visitados.subList(visitados.indexOf(next), visitados.size()));
                ciclo.add(next);
                return sumaCiclo(ciclo) == X;
            }
        }
        visitados.remove(act);
        return false;
    }

    private int sumaCiclo(List<Integer> ciclo) {
        Integer c = 0;
        for (int i = 0; i < ciclo.size() - 1; i++)
            c += grafo.obtenerArco(ciclo.get(i), ciclo.get(i + 1)).getEtiqueta();
        return c;
    }

    public static void main(String[] args) {
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);

        grafo.agregarArco(1, 2, 7);
        grafo.agregarArco(1, 3, 3);
        grafo.agregarArco(2, 3, 1);
        grafo.agregarArco(2, 4, 6);
        grafo.agregarArco(3, 5, 8);
        grafo.agregarArco(4, 3, 3);
        grafo.agregarArco(5, 4, 2);
        grafo.agregarArco(5, 6, 8);
        grafo.agregarArco(4, 6, 2);

        GrafoCiclicoSuma g = new GrafoCiclicoSuma(grafo);

        System.out.println(g.DFS_Ciclo(11));


    }
}
