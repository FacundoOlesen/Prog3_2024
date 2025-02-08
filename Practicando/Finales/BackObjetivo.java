package Practicando.Finales;

import java.util.LinkedList;
import java.util.List;

public class BackObjetivo {
    private List<List<Integer>> solucion;

    public BackObjetivo() {
        this.solucion = new LinkedList<>();
    }

    public List<List<Integer>> back(Integer N, Integer V) {
        List<Integer> solParcial = new LinkedList<>();
        back(N, V, 1, 0, solParcial);
        return solucion;
    }

    private void back(Integer N, Integer V, Integer i, Integer sum, List<Integer> solParcial) {
        if (sum == V) {
            solucion.add(new LinkedList<>(solParcial));
        } else {
            if (i <= N ) {
                solParcial.add(i);
                sum += i;
                if (contarApariciones(solParcial, i) <= 4)
                    back(N, V, i, sum, solParcial);
                solParcial.remove(i);
                sum -= i;
                back(N, V, i + 1, sum, solParcial);
            }
        }
    }

    private int contarApariciones(List<Integer> solParcial, Integer i) {
        int c = 0;
        for (Integer in : solParcial) {
            if (in == i)
                c++;
        }
        return c;
    }

    public static void main(String[] args) {
        BackObjetivo b = new BackObjetivo();
        System.out.println(b.back(3, 5));
    }
}
