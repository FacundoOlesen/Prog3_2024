package TP4.EJ6;

import TP4.EJ1.GrafoDirigido;
import TP4.EJ1.GrafoNoDirigido;

import java.util.*;

public class CaminoMasCortoEntreDosEsquinas {
    private Set<Integer> visitados;
    private Queue<Integer> colaVertices;
    private GrafoNoDirigido<Integer> grafo;


    public CaminoMasCortoEntreDosEsquinas(GrafoNoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
        this.colaVertices = new LinkedList<>();
    }

    public List<Integer> obtenerCaminoMasCortoEntreDosEsquinas(Integer origen, Integer destino) {
        colaVertices.clear();
        visitados.clear();

        visitados.add(origen);
        colaVertices.add(origen);
        return asignarPadresEHijos(origen, destino);
    }

    private List<Integer> asignarPadresEHijos(Integer origen, Integer destino) {
        HashMap<Integer, Integer> hijoPadre = new HashMap<>();
        while (!colaVertices.isEmpty()) {
            int next = colaVertices.remove();
            Iterator<Integer> itAdyacentesAElem = this.grafo.obtenerAdyacentes(next);
            while (itAdyacentesAElem.hasNext()) {
                Integer ady = itAdyacentesAElem.next();
                if (!visitados.contains(ady)) {
                    visitados.add(ady);
                    colaVertices.add(ady);
                    hijoPadre.put(ady, next);
                }

                if (ady == destino) {
                    return reconstruirCamino(hijoPadre, ady);

                }
            }
        }
        return new ArrayList<>();
    }

    private List<Integer> reconstruirCamino(HashMap<Integer, Integer> padres, Integer destino) {
        LinkedList<Integer> res = new LinkedList<>();
        Integer actual = destino;
        while (actual != null) {
            res.add(0, actual);
            actual = padres.get(actual);
        }
        return res;
    }
}