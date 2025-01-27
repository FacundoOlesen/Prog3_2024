package TP6.EJ6;

import TP4.EJ1.GrafoNoDirigido;

import java.util.*;

public class TSP {
    private GrafoNoDirigido<Integer> grafo;
    private Set<Integer> visitados;
    private List<Integer> solucion;

    public TSP(GrafoNoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
        this.solucion = new ArrayList<>();
    }

    public List<Integer> TSP(Integer origen){
        Integer dist = 0;
        Integer actual = origen;
        solucion.add(origen);
        visitados.add(origen);
        while (!solucion()){
            Integer X = seleccionar(actual);
            solucion.add(X);
            visitados.add(X);
            dist += this.grafo.obtenerArco(actual, X).getEtiqueta();
            actual = X;
        }
        solucion.add(origen);
        dist += grafo.obtenerArco(origen, actual).getEtiqueta();
        System.out.println("Con distacia: " + dist);
        return solucion;
    }

    private boolean solucion(){
        return solucion.size() == this.grafo.cantidadVertices() ;
    }

    private Integer seleccionar(Integer act){
        Iterator<Integer> itAdy = grafo.obtenerAdyacentes(act);
        Integer mejor = -1;
        Integer mejorDist = Integer.MAX_VALUE;
        while (itAdy.hasNext()){
            Integer next = itAdy.next();
            Integer pesoArco = grafo.obtenerArco(act, next).getEtiqueta();
            if (!visitados.contains(next) ){
                if(mejor == -1 || pesoArco < mejorDist  ){
                    mejor = next;
                    mejorDist = pesoArco;
                }
            }

        }
        return mejor;
    }
}
