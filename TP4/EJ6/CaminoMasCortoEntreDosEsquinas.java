package TP4.EJ6;

import TP4.EJ1.Grafo;
import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class CaminoMasCortoEntreDosEsquinas {
    private HashMap<Integer, String> visitaVertices;
    private Queue<Integer> colaVertices;
    private List<Integer> solucion;
    private GrafoDirigido<?> grafo;

    private static final String VISITADO = "VISITADO";
    private static final String NO_VISITADO = "NO_VISITADO";

    public CaminoMasCortoEntreDosEsquinas(GrafoDirigido<?> grafo) {
        this.grafo = grafo;
        this.visitaVertices = new HashMap<>();
        this.colaVertices = new LinkedList<>();
        this.solucion = new ArrayList<>();
    }

    public List<Integer> obtenerCaminoMasCortoEntreDosEsquinas(Integer origen, Integer destino) { //INICIALIZO
        colaVertices.clear();
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext())
            visitaVertices.put(itVertices.next(), NO_VISITADO); //PONGO TODOS EN NO VISITADOS
        List<Integer> caminoParcial = new ArrayList<>();
        caminoParcial.add(origen);
        obtenerCaminoMasCortoEntreDosEsquinas(origen, destino, caminoParcial);
        return solucion;
    }

    private void obtenerCaminoMasCortoEntreDosEsquinas(Integer origen, Integer destino, List<Integer> caminoParcial) {
        visitaVertices.put(origen, VISITADO);
        colaVertices.add(origen);
        //CONDICION DE CORTE
        if (origen == destino) {
            if (solucion.isEmpty()) {
                solucion.addAll(caminoParcial);
            } else if (caminoParcial.size() < solucion.size()) {
                solucion.clear();
                solucion.addAll(caminoParcial);
            }
        }
        while (!colaVertices.isEmpty()) {
            int primerElem = colaVertices.remove();
            Iterator<Integer> itAdyacentesAElem = grafo.obtenerAdyacentes(primerElem);
            while (itAdyacentesAElem.hasNext()) {
                Integer next = itAdyacentesAElem.next();
                if (visitaVertices.get(next) == NO_VISITADO) {
                    //APLICO EL NUEVO ESTADO
                    visitaVertices.put(next, VISITADO); //APLICO EL HIJO A LA SOLUCION
                    caminoParcial.add(next);
                    //LLAMADO RECURSIVO
                    obtenerCaminoMasCortoEntreDosEsquinas(next, destino, caminoParcial);
                    //VUELVO AL ESTADO ANTERIOR
                    visitaVertices.put(next, NO_VISITADO);
                    caminoParcial.remove(next);
                }
            }
        }

    }
}
