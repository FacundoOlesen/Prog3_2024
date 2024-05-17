package TP4.EJ4;

import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class CaminoSimpleMayorLongitud {
    private GrafoDirigido<?> grafo;
    private Set<Integer> visitados;

    public CaminoSimpleMayorLongitud(GrafoDirigido<?> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
    }

    public List<Integer> caminoMasLargo(int origen, int destino) {
        List<Integer> caminoMasLargo = new ArrayList<>();

        visitados.add(origen);

        if (origen == destino) {
            caminoMasLargo.add(origen);
        } else {
            Iterator<Integer> itAdyacentes = this.grafo.obtenerAdyacentes(origen);
            while (itAdyacentes.hasNext()) {
                Integer next = itAdyacentes.next();
                if (!visitados.contains(next)) {
                    List<Integer> caminoAdyacente = caminoMasLargo(next, destino);
                    if (caminoAdyacente.size() >= caminoMasLargo.size()) {
                        caminoMasLargo.clear();
                        caminoMasLargo.add(origen);
                        caminoMasLargo.addAll(caminoAdyacente);
                    }
                }
            }
        }
        visitados.remove(origen);
        return caminoMasLargo;
    }
}
