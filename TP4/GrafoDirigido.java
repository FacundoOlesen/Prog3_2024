package TP4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

    private HashMap<Integer, Vertice<T>> vertices;

    @Override
    public void agregarVertice(int verticeId) {
        vertices.put(verticeId, new Vertice<>(verticeId, new HashMap<Integer, Arco<T>>()));
    }

    @Override
    public void borrarVertice(int verticeId) {
        vertices.remove(verticeId);
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Vertice<T> verticeOrigen = vertices.get(verticeId1);
        verticeOrigen.addArco(new Arco<>(verticeId1, verticeId2, etiqueta));
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        Vertice<T> verticeOrigen = vertices.get(verticeId1);
        verticeOrigen.borrarArco(verticeOrigen.getArco(verticeId2));
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int cantidadArcos() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        // TODO Auto-generated method stub
        return null;
    }

}
