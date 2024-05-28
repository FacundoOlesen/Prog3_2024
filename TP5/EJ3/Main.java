package TP5.EJ3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<Integer> conjunto = new ArrayList<>();
        conjunto.add(4);
        conjunto.add(6);
        conjunto.add(2);
        conjunto.add(1);

        SumaDeSubconjuntos algt = new SumaDeSubconjuntos();
        algt.sumaDeSubconjuntos(conjunto, 9);

    }

}
