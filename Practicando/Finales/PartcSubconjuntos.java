package Practicando.Finales;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PartcSubconjuntos {
    private List<List<Integer>> solucion;
    private List<Integer> conjunto;

    public PartcSubconjuntos() {
        this.solucion = new LinkedList<>();
        this.conjunto = new LinkedList<>();

        conjunto.add(5);
        conjunto.add(19);
        conjunto.add(3);
        conjunto.add(7);
        conjunto.add(9);
        conjunto.add(2);
        conjunto.add(1);
        conjunto.add(-10);


    }

    public List<List<Integer>> back(Integer T) {
        List<Integer> solParcial = new LinkedList<>();
        return back(T, 0, 0, solParcial);
    }

    private List<List<Integer>> back(Integer T, Integer it, Integer sum, List<Integer> solParcial) {
        if (solucion.size() == 4)
            return solucion;

        if (sum == T)
            solucion.add(new LinkedList<>(solParcial));

        else {
            if (it < conjunto.size()) {
                Integer act = conjunto.get(it);
                solParcial.add(act);
                sum += act;
                solucion = back(T, it + 1, sum, solParcial);
                if (solucion.size() == 4)
                    return solucion;
                solParcial.remove(act);
                sum -= act;
                back(T, it + 1, sum, solParcial);
            }
        }
            return solucion;
    }

    public static void main(String[] args) {
        PartcSubconjuntos p = new PartcSubconjuntos();
        System.out.println(p.back(9));
    }

}
