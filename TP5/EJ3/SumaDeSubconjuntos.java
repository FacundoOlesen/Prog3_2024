package TP5.EJ3;

import java.util.*;

public class SumaDeSubconjuntos {
    private LinkedList<Integer> conjunto;
    private List<List<Integer>> subConjuntos;

    public SumaDeSubconjuntos() {
        this.conjunto = new LinkedList<>();
        conjunto.add(2);
        conjunto.add(3);
        conjunto.add(6);
        conjunto.add(7);

        this.subConjuntos = new ArrayList<>();
    }

    public List<List<Integer>> back(Integer M) {
        LinkedList<Integer> solucionParcial = new LinkedList<>();
        back(M, 0, 0, solucionParcial);
        return subConjuntos;
    }

    private void back(Integer target, Integer suma, Integer iterador, LinkedList<Integer> solucionParcial) {
        if (suma == target) {
            subConjuntos.add(new LinkedList<>(solucionParcial));
        } else {
            if (iterador < conjunto.size()) {
                Integer num = conjunto.get(iterador);
                 solucionParcial.add(num);
                if (suma <= target)
                    back(target, suma += num, iterador + 1, solucionParcial);
                solucionParcial.remove(num);
                back(target, suma -= num, iterador + 1, solucionParcial);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> conjunto = new ArrayList<>();


        SumaDeSubconjuntos algt = new SumaDeSubconjuntos();
        System.out.println(algt.back(13));
    }
}
