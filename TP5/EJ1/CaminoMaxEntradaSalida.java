package TP5.EJ1;

import TP4.EJ1.Grafo;
import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class CaminoMaxEntradaSalida {

    private Set<Integer> visitados;
    private LinkedList<Integer> solucion;
    private GrafoDirigido<Integer> grafo;

    public CaminoMaxEntradaSalida(GrafoDirigido<Integer> grafo) {
        this.visitados = new HashSet<>();
        this.solucion = new LinkedList<>();
        this.grafo = grafo;
    }


    public LinkedList<Integer> DFSBacktracking(Integer entrada, Integer salida) {
        LinkedList<Integer> solucionParcial = new LinkedList<>();
        solucionParcial.add(entrada);
        Iterator<Integer> itVertices = grafo.obtenerVertices();

        DFS_VisitBacktracking(entrada, salida, solucionParcial);
        return solucion;

    }

    private void DFS_VisitBacktracking(Integer entrada, Integer salida, LinkedList<Integer> solucionParcial) {
        visitados.add(entrada);
        if (entrada == salida) {
            if (solucionParcial.size() > solucion.size()) {
                solucion.clear();
                solucion = new LinkedList<>(solucionParcial);
            }
        }
        Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(entrada);
        while (itAdyacentes.hasNext()) {
            Integer next = itAdyacentes.next();
            if (!visitados.contains(next)) {
                solucionParcial.add(next);
                DFS_VisitBacktracking(next, salida, solucionParcial);
                solucionParcial.remove(next);
            }
        }
        visitados.remove(entrada);
    }
}
