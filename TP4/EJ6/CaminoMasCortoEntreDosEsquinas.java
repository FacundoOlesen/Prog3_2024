package TP4.EJ6;

import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class CaminoMasCortoEntreDosEsquinas {
    private Set<Integer> visitados;
    private Queue<Integer> colaVertices;
    private List<Integer> solucion;
    private GrafoDirigido<?> grafo;

    private static final String VISITADO = "VISITADO";
    private static final String NO_VISITADO = "NO_VISITADO";

    public CaminoMasCortoEntreDosEsquinas(GrafoDirigido<?> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
        this.colaVertices = new LinkedList<>();
        this.solucion = new ArrayList<>();
    }

    public List<Integer> obtenerCaminoMasCortoEntreDosEsquinas(Integer origen, Integer destino) {
        colaVertices.clear();
        solucion.clear();

        List<Integer> solucionParcial = new ArrayList<>();
        solucion.add(origen);
        visitados.add(origen);

        return obtenerCaminoMasCortoEntreDosEsquinasPriv(origen, destino);
    }

    private List<Integer> obtenerCaminoMasCortoEntreDosEsquinasPriv(Integer origen, Integer destino) {
        HashMap<Integer, Integer> padreHijo = new HashMap<>();
        visitados.add(origen);
        colaVertices.add(origen);
        while (!colaVertices.isEmpty()) {
            int primerElem = colaVertices.remove();
            Iterator<Integer> itAdyacentesAElem = this.grafo.obtenerAdyacentes(primerElem);
            while (itAdyacentesAElem.hasNext()) {
                Integer next = itAdyacentesAElem.next();
                if (!visitados.contains(next))
                    padreHijo.put(next, primerElem);
                if (next == destino) {
                    return reconstruirCamino(padreHijo, origen, next);
                }
                if (!visitados.contains(next)) {
                    visitados.add(next);
                    colaVertices.add(next);
                }
            }
        }
        return new ArrayList<>();
    }

    public List<Integer> reconstruirCamino(HashMap<Integer, Integer> padres, Integer origen, Integer destino) {
        LinkedList<Integer> salida = new LinkedList<>();
        Integer actual = destino;
        while (actual != null) {
            salida.add(0, actual);
            actual = padres.get(actual);
        }
        return salida;
    }


}