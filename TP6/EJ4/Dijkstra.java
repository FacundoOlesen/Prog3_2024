package TP6.EJ4;

import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class Dijkstra {
    private GrafoDirigido<Integer> grafo;
    private HashMap<Integer, Integer> dist ;
    private HashMap<Integer, Integer> padre ;
    private Set<Integer> S;

    public Dijkstra(GrafoDirigido<Integer> grafo) {
        this.dist = new HashMap<>();
        this.padre = new HashMap<>();
        this.S = new HashSet<>();
        this.grafo = grafo;
    }

    public void doDijkstra(Integer origen){
        inicializarDist(origen);

        while (S.size() != grafo.cantidadVertices()){ //Mientras que no considere todos los vertices...

            Integer u = minDist(); //Obtengo el vertice que tiene el menor valor (peso) que no haya
                                   //sido considerado (Que no esté en S)
            if (u == -1) {
                throw new IllegalStateException("No hay más vértices accesibles desde los procesados.");
            }
            S.add(u); //Agregar U al conjunto de vertices considerados.

            Iterator <Integer> itAdy = grafo.obtenerAdyacentes(u);
            while (itAdy.hasNext()){
                Integer v = itAdy.next();
                if (!S.contains(v)) {  //Si todavia no considere al v adyacente...
                    Integer distU = dist.get(u);
                    Integer distV = dist.get(v);
                    Integer pesoArco = grafo.obtenerArco(u, v).getEtiqueta();

                    if(distU + pesoArco < distV){
                        dist.put(v, distU + pesoArco);
                        padre.put(v, u);
                    }
                }
            }
        }
        imprimirSolucion();
    }

    private int minDist(){
        Integer u = - 1; Integer minDist = Integer.MAX_VALUE;
        Iterator <Integer> itVertices = grafo.obtenerVertices();

        while (itVertices.hasNext()) {
            Integer next = itVertices.next();
            if (!S.contains(next) && dist.get(next) < minDist) {
                u =  next;
                minDist = dist.get(next);
            }
        }

        return u;
    }

    private void inicializarDist(Integer origen){
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()){
            Integer next = itVertices.next();
            dist.put(next, Integer.MAX_VALUE);
            padre.put(next, null);
        }
        dist.put(origen, 0);
    }

    private void imprimirSolucion(){
        System.out.println("Distancias:");
        System.out.println(dist);

        System.out.println("Padres:");
        System.out.println(padre);
    }
}
