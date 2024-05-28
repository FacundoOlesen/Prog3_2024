package TP5.EJ1;

import TP4.EJ1.GrafoDirigido;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CaminoMaxEntradaSalida {
    private GrafoDirigido<?> grafo;
    private HashSet<Integer> visitados;
    private List<Integer> mejorSolucion;

    public CaminoMaxEntradaSalida(GrafoDirigido<?> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
        this.mejorSolucion = new ArrayList<>();
    }

    public List<Integer> caminoMasLargoEntradaSalida(Integer origen, Integer destino) { //INICIALIZO
        visitados.clear();
        mejorSolucion.clear();

        List<Integer> caminoParcial = new ArrayList<>();
        caminoParcial.add(origen);
        visitados.add(origen);

        caminoMasLargoEntradaSalida(origen, destino, caminoParcial);

        return mejorSolucion;
    }

    private void caminoMasLargoEntradaSalida(Integer actual, Integer destino, List<Integer> solucionParcial) {
        if (actual == destino) {
            if (solucionParcial.size() >= mejorSolucion.size()) {
                mejorSolucion.clear();
                mejorSolucion.addAll(solucionParcial);
            }
        } else {
            Iterator<Integer> itAdyacentes = this.grafo.obtenerAdyacentes(actual);
            while (itAdyacentes.hasNext()) {
                Integer next = itAdyacentes.next();
                if (!visitados.contains(next)) {
                    visitados.add(next);
                    solucionParcial.add(next);
                    caminoMasLargoEntradaSalida(next, destino, solucionParcial);
                    visitados.remove(next);
                    solucionParcial.remove(next);
                }
            }
        }
    }
}
