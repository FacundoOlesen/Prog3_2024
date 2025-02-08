package Practicando.Finales;

import TP4.EJ1.GrafoNoDirigido;

import java.util.*;

public class CicloMasGrande {
    private static final String BLANCO = "BLANCO";
    private static final String NEGRO = "NEGRO";
    private static final String AMARILLO = "AMARILLO";
    private GrafoNoDirigido<Integer> grafo;
    private HashMap<Integer, String> verticeColores;
    private List<Integer> solucion;

    public CicloMasGrande(GrafoNoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.verticeColores = new HashMap<>();
        this.solucion = new ArrayList<>();
    }

    public List<Integer> DFSMaxCicle() {
        Iterator<Integer> itVertices = grafo.obtenerVertices();

        while (itVertices.hasNext())
            verticeColores.put(itVertices.next(), BLANCO);

        itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            Integer next = itVertices.next();
            if (verticeColores.get(next) == BLANCO) {
                List<Integer> caminoActual = new LinkedList<>();
                DFSMaxCicleVisit(next, null, caminoActual);
            }
        }
        return solucion;
    }

    private void DFSMaxCicleVisit(Integer act, Integer padre, List<Integer> solParc) {
        verticeColores.put(act, AMARILLO);
        solParc.add(act);
        Iterator<Integer> itAdy = grafo.obtenerAdyacentes(act);
        while (itAdy.hasNext()) {
            Integer next = itAdy.next();
            if (next == padre)
                continue;
            if (verticeColores.get(next) == BLANCO)
                DFSMaxCicleVisit(next, act, solParc);

            else if (verticeColores.get(next) == AMARILLO) {
                // Construyo el ciclo desde `next` hasta `act`
                int inicioCiclo = solParc.indexOf(next);
                List<Integer> cicloLimpio = new ArrayList<>(solParc.subList(inicioCiclo, solParc.size()));
                cicloLimpio.add(next);
                if (cicloLimpio.size() > solucion.size()) {
                    solucion.clear();
                    solucion.addAll(cicloLimpio);
                }
            }
        }
        solParc.remove(act);
        verticeColores.put(act, NEGRO);
    }

    public static void main(String[] args) {
        GrafoNoDirigido grafito = new GrafoNoDirigido();
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(3);
        grafito.agregarVertice(4);
        grafito.agregarVertice(5);
        grafito.agregarVertice(6);


        grafito.agregarArco(1, 2, "");
        grafito.agregarArco(2, 3, "");
        grafito.agregarArco(3, 4, "");
        grafito.agregarArco(4, 1, "");
        grafito.agregarArco(3, 5, "");
        grafito.agregarArco(5, 6, "");
        grafito.agregarArco(6, 3, "");

        CicloMasGrande c = new CicloMasGrande(grafito);
        System.out.println(c.DFSMaxCicle());
    }
}
