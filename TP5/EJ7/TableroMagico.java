/*package TP5.EJ7;

public class TableroMagico {
    private Tablero tableroMagico;

    public static final int K = 10;
    public static final int N = 3;
    public static final int S = 15;
    private boolean haySolucion;

    public TableroMagico() {
        this.tableroMagico = new Tablero(N, N);
        this.haySolucion = false;
    }

    public tablero back() {
        if (back(1)) ;
        return tablero;
        else
            return null;
    }


    private boolean back(Integer cantAlternativas) {
        if (tableroMagico.estaCompleto() && tableroMagico.sumaFilasMatriz() == S && tableroMagico.sumaColumnasMatriz() == S) {
            haySolucion = true;
            return haySolucion;
        } else {
            for (int i = cantAlternativas; i < K - cantAlternativas; i++) {
                tableroMagico.agregarALaMatriz(i);
                tableroMagico.incrementarFila(i);
                tableroMagico.incrementarColumna(i);

                if (!poda(tableroMagico) && !haySolucion)
                    back(tableroMagico, cantAlternativas + 1);
                tableroMagico.sacarDeLaMatriz(i);
                tableroMagico.decrementarFila(i);
                tableroMagico.decrementarColumna(i);
            }
        }
        return haySolucion;
    }

    private boolean poda(estado) {
        return estado.valorFila() > S || estado.valorColumna() > S || estado.estaCompleta(fila) && estado.valorFila() < S
                || estado.estaCompleta(columna) && estado.valorColumna() < S;
    }
}
*/