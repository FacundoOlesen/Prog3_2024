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
        //IR TOMANDO PADRE HIJO
        //UNA VEZ QUE LLEGO AL DESTINO DEBO AGREGAR PADRE HIJO PARA ATRAS
        HashMap<Integer, Integer> padreHijo = new HashMap<>();
        visitados.add(origen);
        colaVertices.add(origen);
        while (!colaVertices.isEmpty()) {
            int primerElem = colaVertices.remove();
            Iterator<Integer> itAdyacentesAElem = this.grafo.obtenerAdyacentes(primerElem);
            while (itAdyacentesAElem.hasNext()) {
                Integer next = itAdyacentesAElem.next();
                padreHijo.put(next, primerElem);
                padreHijo.put(primerElem, next);
                if (next == destino) {
                    for (int i = 0; i < solucion.size(); i++) {
                        Integer padre = solucion.get(i);
                        Integer hijo = padreHijo.get(padre);
                        solucion.add(hijo);
                        if (hijo == destino)
                            return solucion;
                    }
                }
                if (!visitados.contains(next)) {
                    visitados.add(next);
                    colaVertices.add(next);
                }
            }
        }
        return new ArrayList<>();
    }


}
