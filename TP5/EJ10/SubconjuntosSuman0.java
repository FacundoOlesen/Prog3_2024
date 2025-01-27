package TP5.EJ10;

import java.util.*;

public class SubconjuntosSuman0 {
    private List<Set<Integer>> solucion;
    private LinkedList<Integer> conjunto;

    public SubconjuntosSuman0() {
        this.conjunto = new LinkedList<>();
        conjunto.add(-7);
        conjunto.add(-3);
        conjunto.add(-2);
        conjunto.add(-1);
        conjunto.add(5);
        conjunto.add(8);
        this.solucion = new ArrayList<>();
    }

    public List<Set<Integer>> back(Integer N) {
        LinkedList<Integer> subConjunto = new LinkedList<>();
        back(N, subConjunto, 0, 0);
        return solucion;
    }


    private void back(Integer N, LinkedList<Integer> subConjunto, Integer suma, Integer iterador) {

        if (suma == 0 && subConjunto.size() == N) {
            solucion.add(new HashSet<>(subConjunto));
        } else {
            if (iterador < conjunto.size() && subConjunto.size() <= N) {
                Integer num = conjunto.get(iterador);
                subConjunto.add(num);
                back(N, subConjunto, suma += num, iterador + 1);
                subConjunto.removeLast();
                back(N, subConjunto, suma += num, iterador + 1);
            }
        }
    }

    public static void main(String[] args) {
        SubconjuntosSuman0 p = new SubconjuntosSuman0();
        System.out.println(p.back(3));
    }
}
