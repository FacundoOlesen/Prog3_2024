package TP5.EJ3;

import java.util.*;

public class SumaDeSubconjuntos {
    private LinkedList<Integer> conjunto;
    private List<List<Integer>> subConjuntos;

    public SumaDeSubconjuntos() {
        this.conjunto = new LinkedList<>();
        conjunto.add(4);
        conjunto.add(6);
        conjunto.add(2);
        conjunto.add(1);

        this.subConjuntos = new ArrayList<>();
    }

    public List<List<Integer>> back(Integer M) {
        Integer suma = 0;
        LinkedList<Integer> solucionParcial = new LinkedList<>();
        back(M, suma, 0, solucionParcial);
        return subConjuntos;
    }

    private void back(Integer M, Integer suma, Integer iterador, LinkedList<Integer> solucionParcial) {
        if (suma == M) {
            subConjuntos.add(new LinkedList<>(solucionParcial));
        } else {
            for (int i = iterador; i < conjunto.size(); i++) {
                Integer num = conjunto.get(i);
                solucionParcial.add(num);
                suma += num;
                if (suma <= M)
                    back(M, suma, i + 1, solucionParcial);
                suma -= num;
                solucionParcial.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> conjunto = new ArrayList<>();


        SumaDeSubconjuntos algt = new SumaDeSubconjuntos();
        System.out.println(algt.back(9));
    }
}
