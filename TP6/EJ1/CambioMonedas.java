package TP6.EJ1;

import TP3.EJ6.Libro;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CambioMonedas {
    private List<Integer> candidatos;
    private List<Integer> solucion;

    public CambioMonedas() {
        this.candidatos = new LinkedList<>();
        this.solucion = new LinkedList<>();
        candidatos.add(100);
        candidatos.add(25);
        candidatos.add(10);
        candidatos.add(5);
        candidatos.add(1);

    }

    public List<Integer> greedy(Integer M) {
        Integer suma = 0;
        while (!solucion(suma, M) && suma != null) {
            Integer X = seleccionar();
            if (factible(X, suma, M)) {
                solucion.add(X);
                suma += X;
            } else candidatos.remove(X);
        }
        if (solucion(suma, M))
            return solucion;

        return null;

    }

    private boolean solucion(int suma, int M) {
        return suma == M;
    }

    private Integer seleccionar() {
        return candidatos.size() > 0 ? candidatos.get(0) : null;
    }

    private boolean factible(Integer X, Integer suma, Integer M) {
        return suma + X <= M;
    }

    public static void main(String[] args) {
        CambioMonedas c = new CambioMonedas();
        System.out.println(c.greedy(289));
    }
}
