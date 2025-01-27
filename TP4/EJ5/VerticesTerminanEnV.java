package TP4.EJ5;

import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class VerticesTerminanEnV {
    private GrafoDirigido<Integer> grafo;
    private Set<Integer> visitados;
    private HashSet<Integer> solucion;

    public VerticesTerminanEnV(GrafoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
        this.solucion = new HashSet<>();
    }

    public HashSet<Integer> getVerticesTerminanEnV(Integer verticeDestino) {
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            HashSet<Integer> solucionParcial = new HashSet<>();
            Integer next = itVertices.next();

            solucionParcial.add(next);
            getVerticesTerminanEnV(next, verticeDestino, solucionParcial);
        }

        solucion.remove(verticeDestino);
        if (grafo.existeArco(verticeDestino, verticeDestino))
            solucion.add(verticeDestino);
        return solucion;
    }


    private void getVerticesTerminanEnV(Integer actual, Integer destino, HashSet<Integer> solucionParcial) {
        visitados.add(actual);
        //CONDICION DE CORTE
        if (actual == destino)
            solucion.addAll(solucionParcial);
            //GENERAR CANDIDATOS
        else {
            Iterator<Integer> itAdyacentes = this.grafo.obtenerAdyacentes(actual);
            while (itAdyacentes.hasNext()) {
                Integer next = itAdyacentes.next();
                if (!visitados.contains(next)) {
                    //APLICO EL NUEVO ESTADO
                    solucionParcial.add(next); //APLICO EL CANDIDATO A LA SOLUCIÓN
                    //LLAMADO RECURSIVO
                    getVerticesTerminanEnV(next, destino, solucionParcial);
                    //VUELVO AL ESTADO ANTERIOR
                    solucionParcial.remove(next);
                }
            }
        }
        visitados.remove(actual);
    }
}