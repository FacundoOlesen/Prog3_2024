package TP5.EJ4;

import java.util.*;

public class ParticionSubconjuntosDisjuntos {
    private LinkedList<Integer> conjunto;
    private List<Set<Integer>> subConjuntos;
    private List<Set<Integer>> solucion;
    private boolean haySolucion;

    public ParticionSubconjuntosDisjuntos() {
        this.conjunto = new LinkedList<>();
        conjunto.add(5);
        conjunto.add(7);
        conjunto.add(12);

        this.subConjuntos = new LinkedList<Set<Integer>>();
        this.subConjuntos.add(new HashSet<>());
        this.subConjuntos.add(new HashSet<>());
        this.solucion = new LinkedList<Set<Integer>>();
        this.haySolucion = false;

    }

    public boolean back() {
        Integer suma = 0;
        doBackTracking();
        System.out.println(solucion);
        return haySolucion;
    }

    private boolean doBackTracking() {
        if (conjunto.isEmpty() && suma(subConjuntos.get(0)) == suma(subConjuntos.get(1))) {
            solucion.add(subConjuntos.get(0));
            solucion.add(subConjuntos.get(1));
            haySolucion = true;
            return haySolucion;
        } else {
            if (!conjunto.isEmpty()) {
                Integer num = conjunto.remove();
                for (Set<Integer> estructuraI : subConjuntos) {
                    estructuraI.add(num);
                    haySolucion = doBackTracking();
                    if (haySolucion) return haySolucion;
                    estructuraI.remove(num);
                }
                conjunto.add(num);
            }

        }
        return haySolucion;
    }

    private Integer suma(Set<Integer> conjuntoAComparar) {
        Integer suma = 0;
        for (Integer i : conjuntoAComparar)
            suma += i;
        return suma;
    }


    public static void main(String[] args) {
        List<Integer> conjunto = new ArrayList<>();

        ParticionSubconjuntosDisjuntos algt = new ParticionSubconjuntosDisjuntos();
        System.out.println(algt.back());
    }
}
