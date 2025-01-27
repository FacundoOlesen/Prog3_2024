package TP6.EJ8;

import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class ColoreoGrafo {
    private GrafoDirigido<Integer> grafo;
    private HashMap<Integer, String> coloresAsignados;
    private List<String> colores;

    public ColoreoGrafo(GrafoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.coloresAsignados = new HashMap<>();
        this.colores = new LinkedList<>();
        for (int i = 0; i < grafo.cantidadVertices(); i++){
            char letra = (char) ('A' + i);
            colores.add(String.valueOf(letra));
        }
    }

    public HashMap<Integer, String> colorear(){
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            Integer next = itVertices.next();
            String X = seleccionar(next);
            coloresAsignados.put(next, X);
        }
        return coloresAsignados;
    }

    private String seleccionar(Integer act){
        Iterator<Integer> itAdy = grafo.obtenerAdyacentes(act);
        List<String> coloresDisponibles = new LinkedList<>(this.colores);
        while (itAdy.hasNext()){
            Integer next = itAdy.next();
            coloresDisponibles.remove(coloresAsignados.get(next));
        }

        coloresDisponibles = chequeoPadres(act, coloresDisponibles); //Esto solo es para Grafos Dirigidos

        return coloresDisponibles.get(0);
    }

    private List<String> chequeoPadres(Integer act, List<String> coloresDisponibles){
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            Integer next = itVertices.next();
            Iterator<Integer> itAdyac = grafo.obtenerAdyacentes(next);
            while (itAdyac.hasNext()){
                Integer ady = itAdyac.next();
                if (ady == act)
                    coloresDisponibles.remove(coloresAsignados.get(next));
            }
        }
        return coloresDisponibles;
    }
}
