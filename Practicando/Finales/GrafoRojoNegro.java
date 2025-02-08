package Practicando.Finales;

import TP4.EJ1.GrafoDirigido;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GrafoRojoNegro {
    private GrafoDirigido<Integer> grafo;
    private Set<Integer> visitados;
    private HashMap<Integer, String> verticesColores;

    public GrafoRojoNegro(GrafoDirigido<Integer> grafo, HashMap<Integer, String> verticesColores) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
        this.verticesColores = verticesColores;
    }

    public boolean DFS(Integer V, Integer W) {
        return DFS_Visit(V, null, W);
    }

    private boolean DFS_Visit(Integer act, Integer padre, Integer W) {
        visitados.add(act);
        Iterator<Integer> itAdy = grafo.obtenerAdyacentes(act);
        while (itAdy.hasNext()) {
            Integer next = itAdy.next();
            if (!visitados.contains(next)) {
                if (verticesColores.get(act) != verticesColores.get(next)) {
                    boolean sol = DFS_Visit(next, act, W);
                    if (sol) return sol;
                }
            }
        }
        visitados.remove(act);
        return act == W;
    }

    public static void main(String[] args) {
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        grafo.agregarArco(1, 2, 0);
        grafo.agregarArco(2, 3, 0);
        grafo.agregarArco(3, 4, 0);

        HashMap<Integer, String> verticesColores = new HashMap<>();
        verticesColores.put(1, "Negro");
        verticesColores.put(2, "Rojo");
        verticesColores.put(3, "Negro");
        verticesColores.put(4, "Rojo");


        GrafoRojoNegro g = new GrafoRojoNegro(grafo, verticesColores);
        System.out.println(g.DFS(2, 4));


    }
}
