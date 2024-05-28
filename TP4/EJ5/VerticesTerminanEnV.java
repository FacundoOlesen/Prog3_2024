package TP4.EJ5;

import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class VerticesTerminanEnV {
    private GrafoDirigido<?> grafo;
    private Set<Integer> visitados;
    private HashSet<Integer> solucion;

    public VerticesTerminanEnV(GrafoDirigido<?> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
        this.solucion = new HashSet<>();
    }

    public HashSet<Integer> verticesTerminanEnV(Integer verticeDestino) {
        return getVerticesTerminanEnV(verticeDestino);
    }

    private HashSet<Integer> getVerticesTerminanEnV(Integer verticeDestino) {
        //INICIALIZO
        visitados = new HashSet<>();

        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            Integer next = itVertices.next();
            visitados.add(next);
        }

        Iterator<Integer> itVertices2 = grafo.obtenerVertices();
        while (itVertices2.hasNext()) {
            HashSet<Integer> res = new HashSet<>();
            Integer next = itVertices2.next();
            res.add(next);
            obtenerCamino(next, verticeDestino, res);
        }

        solucion.remove(verticeDestino);
        if (grafo.existeArco(verticeDestino, verticeDestino))
            solucion.add(verticeDestino);

        return solucion;
    }


    private void obtenerCamino(Integer actual, Integer destino, HashSet<Integer> solucionParcial) {
        visitados.remove(actual);

        //CONDICION DE CORTE
        if (actual == destino)
            solucion.addAll(solucionParcial);
        //GENERAR CANDIDATOS
        else {
            Iterator<Integer> itAdyacentes = this.grafo.obtenerAdyacentes(actual);
            while (itAdyacentes.hasNext()) {
                Integer next = itAdyacentes.next();
                if (visitados.contains(next)) {
                    //APLICO EL NUEVO ESTADO
                    solucionParcial.add(next); //APLICO EL CANDIDATO A LA SOLUCIÓN
                    //LLAMADO RECURSIVO
                    obtenerCamino(next, destino, solucionParcial);
                    //VUELVO AL ESTADO ANTERIOR
                    solucionParcial.remove(next);
                }

            }
        }

        visitados.add(actual);
    }
}