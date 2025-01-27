/*
package TP5.EJ7;

public class TableroMagico {
    private Tablero tableroMagico;

    public static final int K = 10;
    public static final int N = 3;
    public static final int S = 15;

    public TableroMagico() {
        this.tableroMagico = new Tablero(N, N);
    }

    public Tablero back(Integer it) {
        if (tableroMagico.estaCompleto()  ) {
            if(tableroMagico.sumaFilasMatriz() == S && tableroMagico.sumaColumnasMatriz() == S)
              return tableroMagico;
        }
        else {
            for (int i = it; i <= K ; i++) {
                tableroMagico.agregarALaMatriz(i);
                if (tablero.sumaFilas() < S && tablero.sumaColumnas() < S)
                   tableroMagico =  back(it + 1);
                 if(tableroMagico != null)
                    return tableroMagico;
                tableroMagico.sacarDeLaMatriz(i);
            }
        }
        return null;
    }
}
*/