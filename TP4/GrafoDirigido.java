package TP4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    private int cantVertices = 0;
    private int cantArcos = 0;
    private HashMap<Integer, Integer> vertices;
    private ArrayList<Arco<T>> arcos;


    public GrafoDirigido() {
        this.vertices = new HashMap<>();
        this.arcos= new ArrayList<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        vertices.put(verticeId, verticeId);
        cantVertices++;
    }

    @Override
    public void borrarVertice(int verticeId) {
        for (int i = 0; i < arcos.size(); i++) {
            Arco<T> arcoHijo = arcos.get(i);
            if (arcoHijo.getVerticeOrigen() == verticeId || arcoHijo.getVerticeDestino() == verticeId) {
                arcos.remove(i);
            }
        }
        vertices.remove(verticeId);
        cantVertices--;
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        arcos.add(new Arco<>(verticeId1, verticeId2, etiqueta));
        cantArcos++;
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        for (int i = 0; i < arcos.size(); i++) {
            Arco<T> arcoHijo = arcos.get(i);
            if (arcoHijo.getVerticeOrigen() == verticeId1 && arcoHijo.getVerticeDestino() == verticeId2) {
                arcos.remove(i);
            }
        }
        cantArcos--;
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.get(verticeId) != null;
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        for (int i = 0; i < arcos.size(); i++) {
            Arco<T> arcoHijo = arcos.get(i);
            if (arcoHijo.getVerticeOrigen() == verticeId1 && arcoHijo.getVerticeDestino() == verticeId2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        for (int i = 0; i < arcos.size(); i++) {
            Arco<T> arcoHijo = arcos.get(i);
            if (arcoHijo.getVerticeOrigen() == verticeId1 && arcoHijo.getVerticeDestino() == verticeId2) {
                return arcoHijo;
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return cantVertices;
    }

    @Override
    public int cantidadArcos() {
        return cantArcos;
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
