package TP4.EJ8;


import java.util.*;

public class TareasMayorEjec {
    private List<Tarea> solucion;
    private GrafoDirigido<Tarea> grafo;
    private Set<Tarea> visitados;
    private Integer mayorSum;

    public Integer getMayorSum() {
        return mayorSum;
    }

    public TareasMayorEjec(GrafoDirigido<Tarea> grafo) {
        this.solucion = new LinkedList<>();
        this.grafo = grafo;
        this.visitados = new HashSet<>();
        this.mayorSum = 0;
    }

    public List<Tarea> getTareasMaxTiempoEjec(Tarea tareaBase) {
        solucion.clear();
        visitados.clear();

        List<Tarea> solParcial = new LinkedList<>();
        solParcial.add(tareaBase);

        getTareasMaxTiempoEjec(tareaBase, 0, solParcial);

        return solucion;
    }

    private void getTareasMaxTiempoEjec(Tarea act, Integer sum, List<Tarea> solParcial) {
        visitados.add(act);

        Integer tiempoEjec = act.getDuracion(); //Obtengo la duración de la tarea actual.

        if (!grafo.obtenerAdyacentes(act).hasNext()) { //Si la tarea actual no tiene tareas despues...
            sum += tiempoEjec;
            if (sum > mayorSum) {
                this.mayorSum = sum;
                solucion.clear();
                solucion.addAll(solParcial);
            }
        }

        else {
            Iterator<Tarea> itAdy = grafo.obtenerAdyacentes(act);
            while (itAdy.hasNext()) {
                Tarea next = itAdy.next();
                if (!visitados.contains(next)) {
                    Integer tiempoEspera = grafo.obtenerArco(act, next).getEtiqueta();  //Obtengo el tiempo de espera entre la tarea actual y la siguiente.

                    solParcial.add(next);
                    getTareasMaxTiempoEjec(next, sum + tiempoEspera + tiempoEjec, solParcial);
                    solParcial.remove(next);
                }

            }
        }

        visitados.remove(act);
    }
}