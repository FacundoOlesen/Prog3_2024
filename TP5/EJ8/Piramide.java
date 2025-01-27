/*package TP5.EJ8;

import java.util.*;

public class Piramide {
    private Matriz solucion;

    public Piramide() {
    }

    public Matriz back(Casilla Inicial) {
        Matriz solParc = new Matriz(inicial);
        return back(solParc, 1);
    }

    private Matriz back(Matriz solParc, Integer it) {
        if(solParc.estaOrdenada()){
            if (solParc.getPosVacia()= 4.4) {
                solucion = solParc;
                return solucion;
            }
        }
        else{
            for(int i = it; i<=15; i++){
                solParc.intercambiar(i);
                solucion = back(solParc, it+1);
                if(solucion!=null)
                    return solucion;
                solParc.restablecer(i);
            }
        }
        return null;
    }
}
*/