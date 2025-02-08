package Practicando.Finales;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class CiudadsBacktracking {
    private List<String> estaciones;
    private List<String> solucion;

    public CiudadsBacktracking(List<String> estaciones) {
        this.estaciones = estaciones;
        this.solucion = new ArrayList<>();
    }

    public List<String> back(String origen, String destino, Integer K) {
        List<String> solParc = new ArrayList<>();
        solParc.add(origen);
        back(origen, destino, 1, K, solParc);
        return solucion;
    }

    private void back(String act, String destino, Integer it, Integer K, List<String> solParc) {
        if (act.equals(destino)) {
            System.out.println(solParc);
            if (solucion.isEmpty() || solParc.size() < solucion.size()) {
                solucion.clear();
                solucion.addAll(new ArrayList<>(solParc));
            }
        } else {
            if (it < estaciones.size()) {
                String next = estaciones.get(it);
                solParc.add(next);
                back(next, destino, it + 1, K, solParc);
                solParc.remove(solParc.size() - 1);
                back(act, destino, it + 1, K, solParc);
            }
        }
    }

    public static void main(String[] args) {
        List<String> estaciones = new ArrayList<>();
        estaciones.add("E1");
        estaciones.add("E2");
        estaciones.add("E3");
        estaciones.add("E4");
        estaciones.add("E5");



        CiudadsBacktracking c = new CiudadsBacktracking(estaciones);
        System.out.println(c.back("E1", "E5", 32131));

    }
}
