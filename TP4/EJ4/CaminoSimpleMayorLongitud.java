package TP4.EJ4;

import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class CaminoSimpleMayorLongitud {
    private GrafoDirigido<Integer> grafo;
    private HashSet<Integer> visitados;
    private List<Integer> mejorSolucion;

    public CaminoSimpleMayorLongitud(GrafoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
        this.mejorSolucion = new ArrayList<>();
    }

    public List<Integer> caminoMasLargo(Integer origen, Integer destino) { //INICIALIZO
        visitados.clear(); // "PONER  EN BLANCO TODOS LOS NODOS"
        mejorSolucion.clear();

        List<Integer> caminoParcial = new ArrayList<>();
        caminoParcial.add(origen);
        visitados.add(origen);

        caminoMasLargo(origen, destino, caminoParcial);

        return mejorSolucion;
    }

    private void caminoMasLargo(Integer origen, Integer destino, List<Integer> solucionParcial) {
        if (origen == destino) { //CONDICION DE CORTE
            if (solucionParcial.size() >= mejorSolucion.size()) {
                mejorSolucion.clear();
                mejorSolucion.addAll(solucionParcial);
            }
        } else {  //GENERAR CANDIDATOS
            Iterator<Integer> itAdyacentes = this.grafo.obtenerAdyacentes(origen);
            while (itAdyacentes.hasNext()) {
                Integer next = itAdyacentes.next();
                if (!visitados.contains(next)){
                    //APLICO EL NUEVO ESTADO (aplicar(estado,candidato))
                    solucionParcial.add(next); //EL HIJO (CANDIDATO) LO APLICO A LA SOLUCIÓN
                    visitados.add(next);
                    //LLAMADO RECURSIVO
                    caminoMasLargo(next, destino, solucionParcial);
                    //VOLVER AL ESTADO ANTERIOR (deshacer)
                    solucionParcial.remove(next);
                    visitados.remove(next);
                }
            }
        }
    }
}
