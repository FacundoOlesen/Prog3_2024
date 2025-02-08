package Practicando.Finales;

import TP4.EJ1.GrafoDirigido;
import TP4.EJ1.GrafoNoDirigido;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EsGrafoConectado {
    private Set<Integer> visitados;
    private GrafoNoDirigido<Integer> grafo;

    public EsGrafoConectado(GrafoNoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<>();
    }

    public boolean esConectado() {
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        return visit(itVertices.next());
    }

    private boolean visit(Integer act) {
        visitados.add(act);
        Iterator<Integer> itAdy = grafo.obtenerAdyacentes(act);
        while (itAdy.hasNext()) {
            Integer next = itAdy.next();
            if (!visitados.contains(next))
                visit(next);
        }

        if (visitados.size() == grafo.cantidadVertices())
            return true;

        visitados.remove(act);
        return false;
    }

    public static void main(String[] args) {
        GrafoNoDirigido<Integer> grafo = new GrafoNoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);

        grafo.agregarArco(1, 2, 0);
        grafo.agregarArco(2, 3, 0);

        EsGrafoConectado e = new EsGrafoConectado(grafo);
        System.out.println(e.esConectado());
    }
}
