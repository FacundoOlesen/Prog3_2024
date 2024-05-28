package TP5.EJ3;

import java.util.*;

public class SumaDeSubconjuntos {
    private List<Integer> conjunto;
    private List<Integer> solucion;

    public SumaDeSubconjuntos() {
        this.conjunto = new ArrayList<>();
        this.solucion = new ArrayList<>();
    }

    public List<Integer> sumaDeSubconjuntos(List<Integer> conjunto, Integer t) {
        List<Integer> solucionParcial0 = new ArrayList<>();
        List<Integer> solucionParcial = new ArrayList<>();

        sumaDeSubconjuntos(conjunto, t, 0, solucionParcial);
        return solucion;
    }

    private void sumaDeSubconjuntos(List<Integer> conjunto, Integer t, Integer actual, List<Integer> solucionParcial) {
        if (t != t)
            System.out.println("hola");
        else {
            for (int i = actual; i < conjunto.size(); i++) {
                Integer next = conjunto.get(i);
                solucionParcial.remove(next);
                solucionParcial.add(1);
                sumaDeSubconjuntos(conjunto, t, actual + 1, solucionParcial);
                solucionParcial.remove(i);
                solucionParcial.add(0);
            }
        }

    }
}
