package TP4.EJ5;

import TP4.EJ1.GrafoDirigido;

import java.util.*;

public class VerticesTerminanEnV {
    private GrafoDirigido<?> grafo;
    private static final String BLANCO = "BLANCO";
    private static final String AMARILLO = "AMARILLO";
    private static final String NEGRO = "NEGRO";
    private HashMap<Integer, String> visitados;
    private List<Integer> solucion;

    public VerticesTerminanEnV(GrafoDirigido<?> grafo) {
        this.grafo = grafo;
        this.visitados = new HashMap<>();
        this.solucion = new ArrayList<>();
    }

    public List<Integer> verticesTerminanEnV(Integer v) {
        return verticesTerminanEnV(null, v);
    }

    private List<Integer> verticesTerminanEnV(Integer sig, Integer v) { //INICIALIZO
        ArrayList<Integer> solucionParcial = new ArrayList<>();
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            visitados.put(itVertices.next(), BLANCO); //PONGO EN BLANCO TODOS LOS VERTICES
        }
        Iterator<Integer> itVertices2 = grafo.obtenerVertices();
        while (itVertices2.hasNext()) {
            Integer next = itVertices2.next();
            if (visitados.get(next) == BLANCO) {
                verticesTerminanEnV(next, v, solucionParcial);
            }
        }
        return solucion;
    }

    private void verticesTerminanEnV(Integer actual, Integer v, ArrayList<Integer> solucionParcial) {
        //visitados.put(actual, AMARILLO);
        //CONDICION DE CORTE
        if (actual == v) {
            solucion.addAll(solucionParcial);
        }
        //GENERAR CANDIDATOS
        else {
            Iterator<Integer> itAdyacentes = this.grafo.obtenerAdyacentes(actual);
            while (itAdyacentes.hasNext()) {
                Integer next = itAdyacentes.next();
                if (visitados.get(actual) == BLANCO) {
                    //APLICO EL NUEVO ESTADO
                    if (!solucion.contains(actual)) //PARA QUE NO ME AGREGUE 2 VECES UN VERTICE QUE TENGA 2 O MAS ADYACENTES QUE VAYAN A V
                        solucionParcial.add(actual);  //EL ACTUAL (CANDIDATO) LO APLICO A LA SOLUCIÓN
                    visitados.put(actual, NEGRO);
                    //LLAMADO RECURSIVO
                    verticesTerminanEnV(next, v, solucionParcial);
                    //VOLVER AL ESTADO ANTERIOR(DESHACER)
                    solucionParcial.remove(actual);
                    visitados.put(actual, BLANCO);
                }

            }
        }
        visitados.put(actual, NEGRO);
    }
}