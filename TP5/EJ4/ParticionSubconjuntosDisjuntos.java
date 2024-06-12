package TP5.EJ4;

import java.util.*;

public class ParticionSubconjuntosDisjuntos {
    private LinkedList<Integer> conjunto;
    private List<Set<Integer>> subConjuntos;

    public ParticionSubconjuntosDisjuntos() {
        this.conjunto = new LinkedList<>();
        conjunto.add(5);
        conjunto.add(7);
        conjunto.add(4);
        conjunto.add(8);

        this.subConjuntos = new ArrayList<>();
    }

    public boolean back() {
        Integer suma = 0;
        LinkedList<Integer> solucionParcial = new LinkedList<>();
        boolean existe = back(suma, solucionParcial);
        System.out.println("Primer subconjunto encontrado: " + subConjuntos);
        return existe;
    }

    private boolean back(Integer suma, LinkedList<Integer> solucionParcial) {
        if (suma == suma(conjunto)) {
            subConjuntos.add(new HashSet<>(solucionParcial));
            subConjuntos.add(new HashSet<>(conjunto));
            return true;
        } else {
            for (int i = 0; i < conjunto.size(); i++) {
                Integer num = conjunto.get(i);
                solucionParcial.add(num);
                conjunto.remove(num);
                suma += num;
                if (back(suma, solucionParcial))
                    return true;
                suma -= num;
                conjunto.add(num);
                solucionParcial.removeLast();
            }
        }
        return false;
    }

    private Integer suma(LinkedList<Integer> conjuntoAComparar) {
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
