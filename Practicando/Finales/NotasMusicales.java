package Practicando.Finales;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class NotasMusicales {
    private List<Integer> notasMusicales;
    private List<Integer> solucion;

    public NotasMusicales(List<Integer> notasMusicales) {
        this.notasMusicales = notasMusicales;
        this.solucion = new ArrayList<>();
    }

    public List<Integer> back(Integer H) {
        List<Integer> solParc = new ArrayList<>();
        back(-1, H, solParc);
        return solParc;
    }

    private void back(Integer ult, Integer H, List<Integer> solParc) {
        if (solParc.size() == H) {
            System.out.println(solParc);
            //if(valoracion(solParc) > valoracion(solucion) {
            solucion.clear();
            solucion.addAll(solParc);
        } else {
            for (int i = 0; i < notasMusicales.size(); i++) {
                Integer act = notasMusicales.get(i);
                solParc.add(act);
                if (act != ult) //Para no insertar 2 numeros iguales seguidos.
                    back(act, H, solParc);
                solParc.remove(solParc.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> notasMusicales = new ArrayList<>();
        notasMusicales.add(1);
        notasMusicales.add(2);
        notasMusicales.add(3);
        NotasMusicales n = new NotasMusicales(notasMusicales);
        System.out.println(n.back(3));
    }
}
