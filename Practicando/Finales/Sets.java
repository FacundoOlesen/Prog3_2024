package Practicando.Finales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Sets {
    private List<List<Integer>> solucion;
    private HashMap<Integer, Integer> ocurrencias;

    public Sets() {
        this.solucion = new ArrayList<>();
        this.ocurrencias = new HashMap<>();
    }

    public List<List<Integer>> back(Integer N, Integer V) {
        List<Integer> solParcial = new ArrayList<>();
        back(N, V, 0, solParcial, 1);
        return solucion;
    }

    private void back(Integer N, Integer V, Integer sum, List<Integer> solParc, Integer it) {
        if (sum == V) {
            solucion.add(new ArrayList<>(solParc));
        } else {
            if (it <= N) {
                solParc.add(it);
                sum += it;
                ocurrencias.put(it, ocurrencias.getOrDefault(it, 0) + 1);
                if (ocurrencias.get(it) <= 4)
                    back(N, V, sum, solParc, it);
                sum -= it;
                ocurrencias.put(it, ocurrencias.get(it) - 1);
                solParc.remove(solParc.size() - 1);
                back(N, V, sum, solParc, it + 1);
            }
        }
    }

    public static void main(String[] args) {
        Sets x = new Sets();
        System.out.println(x.back(3, 5));
    }
}
