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
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        List<Integer> caminoParcial = new ArrayList<>();
        //solucion.add(origen);
        obtenerCaminoMasCortoEntreDosEsquinas(origen, destino, caminoParcial);
        return solucion;
    }

    private void obtenerCaminoMasCortoEntreDosEsquinas(Integer actual, Integer destino, List<Integer> solucionParcial) {
        HashMap<Integer, Integer> padreHijos = new HashMap<>();
        visitados.add(actual);
        colaVertices.add(actual);
        solucionParcial.add(actual);
        while (!colaVertices.isEmpty()) {
            int primerVerticeCola = colaVertices.remove();
            Iterator<Integer> itAdyacentesAprimerVerticeCola = grafo.obtenerAdyacentes(primerVerticeCola);
            while (itAdyacentesAprimerVerticeCola.hasNext()) {
                Integer next = itAdyacentesAprimerVerticeCola.next();
                if (!visitados.contains(next)) {
                    visitados.add(next);
                    colaVertices.add(next);
                    padreHijos.put(next, primerVerticeCola);
                }
            }
        }
        if (padreHijos.containsValue(destino)) {
            solucion.add(padreHijos.get(destino));
        }
        System.out.println(padreHijos);
    }


}
