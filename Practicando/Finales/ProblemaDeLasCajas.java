package Practicando.Finales;

import java.util.*;

public class ProblemaDeLasCajas {
    private List<Caja> candidatos;
    private HashMap<Integer, List<Caja>> solucion;


    public ProblemaDeLasCajas(List<Caja> candidatos) {
        this.candidatos = candidatos;
        this.solucion = new HashMap<>();
        this.candidatos.sort(Comparator.comparingInt(Caja::getResistencia).reversed());
    }

    public Integer greedy() {
        Integer pesoUltCol = 0;
        while (!solucion()) {
            Caja x = seleccionar();
            List<Caja> aux = new LinkedList<>();
            aux.add(x);
            if (solucion.isEmpty() || !factible(x, pesoUltCol)) {
                pesoUltCol = 0;
                solucion.put(solucion.size(), aux); //Agregar en la ultima columna existente
            } else {
                pesoUltCol += x.getPeso();
                solucion.get(solucion.size() - 1).add(x); //Crear una nueva columna y agregarla ahi
            }
            candidatos.remove(x);
        }
        return solucion.size();
    }

    private boolean solucion() {
        return candidatos.isEmpty();
    }

    private Caja seleccionar() {
        return candidatos.get(0);
    }

    private boolean factible(Caja x, Integer pesoUltCol) {
        return pesoUltCol + x.getPeso() <= solucion.get(solucion.size() - 1).get(0).getResistencia();
    }

    public static void main(String[] args) {
        Caja c1 = new Caja("A", 20, 324);
        Caja c2 = new Caja("B", 50, 10);
        Caja c3 = new Caja("C", 60, 15);
        Caja c4 = new Caja("D", 30, 8);


        List<Caja> cajas = new ArrayList<>();
        cajas.add(c1);
        cajas.add(c2);
        cajas.add(c3);
        cajas.add(c4);

        ProblemaDeLasCajas p = new ProblemaDeLasCajas(cajas);

        System.out.println(p.greedy());
    }
}
