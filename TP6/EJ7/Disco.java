package TP6.EJ7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Disco {
    private List<Cancion> solucion;
    private List<Cancion> candidatos;
    private HashMap<String, Integer> cantGeneros;

    public Disco(List<Cancion> canciones) {
        this.solucion = new ArrayList<>();
        this.candidatos = new ArrayList<>(canciones);
        this.cantGeneros = new HashMap<>();
        for (Cancion c : candidatos) {
            cantGeneros.put(c.getGenero(), 0);
        }
    }

    public List<Cancion> greedy(Integer M){
        Integer KBsAcumulados = 0;
        while (!solucion(KBsAcumulados, M)){
            Cancion X = seleccionar();

            if (X == null) return  solucion;

            candidatos.remove(X);

            if(factible(KBsAcumulados + X.getTamanio(),  M, X.getGenero())){
                solucion.add(X);
                KBsAcumulados += X.getTamanio();
                cantGeneros.put(X.getGenero(), cantGeneros.getOrDefault(X.getGenero() ,0) + 1);
            }
        }
        return solucion;
    }

    private boolean solucion(Integer KBsAcumulados, Integer M){
        return candidatos.isEmpty() || KBsAcumulados == M;
    }

    private Cancion seleccionar(){
        Cancion mejor = null;
        Integer menorKB = Integer.MAX_VALUE;
        for (Cancion c : candidatos){
            if (mejor == null || c.getTamanio() < menorKB){
                mejor = c;
                menorKB = c.getTamanio();
            }
        }
        return mejor;
    }

    private boolean factible(Integer KBsAcumulaodos, Integer M, String genero){
        return KBsAcumulaodos <= M && cantGeneros.get(genero) < 3 ;
    }
}
