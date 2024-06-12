package TP5.EJ1;

import TP4.EJ1.Grafo;
import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class CaminoMaxEntradaSalida {
    private static final String BLANCO = "BLANCO";
    private static final String AMARILLO = "AMARILLO";
    private static final String NEGRO = "NEGRO";
    private HashMap<Integer, String> verticesColores;
    private LinkedList<Integer> solucion;
    private GrafoDirigido<Integer> grafo;

    public CaminoMaxEntradaSalida(GrafoDirigido<Integer> grafo) {
        this.verticesColores = new HashMap<>();
        this.solucion = new LinkedList<>();
        this.grafo = grafo;
    }


    public LinkedList<Integer> DFSBacktracking(Integer entrada, Integer salida) {
        LinkedList<Integer> solucionParcial = new LinkedList<>();
        solucionParcial.add(entrada);
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext())
            verticesColores.put(itVertices.next(), BLANCO);
        DFS_VisitBacktracking(entrada, salida, solucionParcial);
        return solucion;

    }

    private void DFS_VisitBacktracking(Integer entrada, Integer salida, LinkedList<Integer> solucionParcial) {
        if (entrada == salida) {
            if (solucionParcial.size() > solucion.size()) {
                solucion.clear();
                solucion = new LinkedList<>(solucionParcial);
            }
        }
        Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(entrada);
        while (itAdyacentes.hasNext()) {
            Integer next = itAdyacentes.next();
            if (verticesColores.get(next) == BLANCO) {
                verticesColores.put(entrada, AMARILLO);
                solucionParcial.add(next);
                DFS_VisitBacktracking(next, salida, solucionParcial);
                solucionParcial.remove(next);
                verticesColores.put(entrada, NEGRO);
            }
        }
    }
}
