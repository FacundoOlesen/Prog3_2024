package TP4.EJ5;

import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class CaminosDesdeOrigenADestino {
    private GrafoDirigido<String> grafo;
    private Set<String> visitados;
    private List<List<String>> solucion;


    public CaminosDesdeOrigenADestino(GrafoDirigido<String> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
        this.solucion = new ArrayList<>();
    }

    public List<List<String>> obtenerCaminosDeOrigenADestino(String verticeOrigen, String verticeDestino, String origenCortado, String destinoCortado) {
        solucion.clear();
        List<String> solucionParcial = new LinkedList<>();
        solucionParcial.add(verticeOrigen);
        obtenerCaminosDeOrigenADestino(verticeOrigen, verticeDestino, solucionParcial, origenCortado, destinoCortado);
        return solucion;
    }


    private void obtenerCaminosDeOrigenADestino(String actual, String destino, List<String> solucionParcial, String origenCortado, String destinoCortado) {
        visitados.add(actual);
        //CONDICION DE CORTE
        if (actual == destino)
            solucion.add(new LinkedList<>(solucionParcial));
            //GENERAR CANDIDATOS
        else {
            Iterator<String> itAdyacentes = this.grafo.obtenerAdyacentes(actual);

            while (itAdyacentes.hasNext()) {
                String next = itAdyacentes.next();
                if (!visitados.contains(next)) {
                    if (actual != origenCortado && next != destinoCortado) {
                        //APLICO EL NUEVO ESTADO
                        solucionParcial.add(next);
                        //LLAMADO RECURSIVO
                        obtenerCaminosDeOrigenADestino(next, destino, solucionParcial, origenCortado, destinoCortado);
                        //VUELVO AL ESTADO ANTERIOR
                        solucionParcial.remove(next);
                    }
                }
            }
        }
        visitados.remove(actual);
    }
}