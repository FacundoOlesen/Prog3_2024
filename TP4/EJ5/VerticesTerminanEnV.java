package TP4.EJ5;

import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class VerticesTerminanEnV {
    private GrafoDirigido<?> grafo;
    private static final String BLANCO = "BLANCO";
    private static final String AMARILLO = "AMARILLO";
    private static final String NEGRO = "NEGRO";
    private HashMap<Integer, String> visitados;

    public VerticesTerminanEnV(GrafoDirigido<?> grafo) {
        this.grafo = grafo;
        this.visitados = new HashMap<>();
    }

    public List<Integer> verticesTerminanEnV(Integer v) {
        return verticesTerminanEnV(null, v);
    }

    private List<Integer> verticesTerminanEnV(Integer sig, Integer v) {
        ArrayList<Integer> res = new ArrayList<>();
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            visitados.put(itVertices.next(), BLANCO);
        }
        Iterator<Integer> itVertices2 = grafo.obtenerVertices();
        while (itVertices2.hasNext()) {
            Integer next = itVertices2.next();
            if (visitados.get(next) == BLANCO) {
                recorroAdyacentes(next, v, res);
            }
        }
        return res;
    }

    private List<Integer> recorroAdyacentes(Integer sig, Integer v, ArrayList<Integer> res) {
        visitados.put(sig, AMARILLO);
        Iterator<Integer> itAdyacentes = this.grafo.obtenerAdyacentes(sig);
        while (itAdyacentes.hasNext()) {
            Integer next = itAdyacentes.next();
            if (visitados.get(next) == BLANCO) {
                List<Integer> caminoAdyacente = recorroAdyacentes(next, v, res);
            } else if (visitados.get(next) == AMARILLO)
                System.out.println("Ciclo (Arco Back)");
            if (next == v)
                res.add(sig);
            else if (res.contains(next) && !res.contains(sig))
                res.add(sig);
        }
        visitados.put(sig, NEGRO);
        return res;
    }
}