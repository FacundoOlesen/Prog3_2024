package Practicando.Finales;

import java.util.LinkedList;
import java.util.List;

public class BackObjetivo2 {
    private List<List<Integer>> solucion;

    public BackObjetivo2() {
        this.solucion = new LinkedList<>();
    }

    public List<List<Integer>> back(Integer N, Integer V) {
        List<Integer> solParcial = new LinkedList<>();
        back(N, V, 1, 0, solParcial);
        return solucion;
    }

    private void back(Integer N, Integer V, Integer it, Integer sum, List<Integer> solParcial) {
        if (sum == V)
            solucion.add(new LinkedList<>(solParcial));
        else {
            if (it <= N && sum <= V) {
                solParcial.add(it);
                sum += it;
                back(N, V, it, sum, solParcial);
                solParcial.remove(it);
                sum -= it;
                back(N, V, it + 1, sum, solParcial);
            }
        }
    }

    public static void main(String[] args) {
        BackObjetivo2 b = new BackObjetivo2();
        System.out.println(b.back(2, 3));
    }

}
