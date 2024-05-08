package TP4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    private int cantVertices = 0;
    private int cantArcos = 0;
    private HashMap<Integer, Vertice<T>> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!this.contieneVertice(verticeId)) {
            vertices.put(verticeId, new Vertice(verticeId));
            cantVertices++;
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (this.contieneVertice(verticeId)) {
            Vertice<T> verticeABorrar = vertices.get(verticeId);
            verticeABorrar.borrarTodosLosArcos();
            for (int i = 0; i < vertices.size(); i++)
                vertices.get(i).borrarArco(verticeId);

            vertices.remove(verticeId);
            cantVertices--;
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Vertice<T> verticeOrigen = vertices.get(verticeId1);
        verticeOrigen.addArco(new Arco(verticeId1, verticeId2, etiqueta));
        cantArcos++;
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        Vertice<T> verticeOrigen = vertices.get(verticeId1);
        verticeOrigen.borrarArco(verticeId2);
        cantArcos--;
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.get(verticeId) != null;
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        Vertice<T> verticeOrigen = vertices.get(verticeId1);
        return verticeOrigen.existeArco(verticeId2);
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        Vertice<T> verticeOrigen = vertices.get(verticeId1);
        return verticeOrigen.obtenerArco(verticeId2);
    }

    @Override
    public int cantidadVertices() {
        return this.cantVertices;
    }

    @Override
    public int cantidadArcos() {
        return this.cantArcos;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        ArrayList<Integer> valoresVertices = new ArrayList<>();
        for (int i = 0; i < this.cantVertices; i++)
            valoresVertices.add(vertices.get(i).getVerticeId());
        return valoresVertices.iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        Vertice<T> verticeBuscado = vertices.get(verticeId);
        ArrayList<Integer> verticesAdyacentes = new ArrayList<>();
        ArrayList<Arco<T>> arcosVerticeBuscado = new ArrayList<>(verticeBuscado.getArcos());

        for (int i = 0; i < arcosVerticeBuscado.size(); i++)
            verticesAdyacentes.add(arcosVerticeBuscado.get(i).getVerticeDestino());

        return verticesAdyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> arcos = new ArrayList<>();
        for (int i = 0; i < this.cantVertices; i++)
            arcos.addAll(vertices.get(i).getArcos());
        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        Vertice<T> verticeBuscado = vertices.get(verticeId);
        return verticeBuscado.getArcos().iterator();
    }
}