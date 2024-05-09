package TP4.EJ1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    private int cantVertices = 0;
    private int cantArcos = 0;
    private HashMap<Integer, ArrayList<Arco<T>>> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!this.contieneVertice(verticeId)) {
            vertices.put(verticeId, new ArrayList<Arco<T>>());
            cantVertices++;
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (this.contieneVertice(verticeId)) {
            ArrayList<Arco<T>> arcosABorrar = new ArrayList<>(vertices.get(verticeId));
            for (int i = 0; i < arcosABorrar.size(); i++) {
                Arco<T> arcoHijo = arcosABorrar.get(i);
                if (arcoHijo.getVerticeDestino() == verticeId) {
                    vertices.get(i).remove(arcoHijo);
                    cantArcos--;
                }
            }
            vertices.remove(verticeId);
            cantVertices--;
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (!existeArco(verticeId1, verticeId2)) {
            ArrayList<Arco<T>> arcosDeOrigen = vertices.get(verticeId1);
            arcosDeOrigen.add(new Arco(verticeId1, verticeId2, etiqueta));

            vertices.put(verticeId1, arcosDeOrigen);
            cantArcos++;
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (existeArco(verticeId1, verticeId2)) {
            ArrayList<Arco<T>> arcosDeOrigen = vertices.get(verticeId1);
            for (int i = 0; i < arcosDeOrigen.size(); i++) {
                Arco<T> arcoHijo = arcosDeOrigen.get(i);
                if (arcoHijo.getVerticeDestino() == verticeId2) {
                    arcosDeOrigen.remove(arcoHijo);
                    cantArcos--;
                }
            }
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.get(verticeId) != null;
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if (contieneVertice(verticeId1)) {
            ArrayList<Arco<T>> arcosDeOrigen = vertices.get(verticeId1);
            for (int i = 0; i < arcosDeOrigen.size(); i++) {
                if (arcosDeOrigen.get(i).getVerticeDestino() == verticeId2)
                    return true;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        ArrayList<Arco<T>> arcosDeOrigen = vertices.get(verticeId1);
        for (int i = 0; i < arcosDeOrigen.size(); i++) {
            Arco<T> arcoHijo = arcosDeOrigen.get(i);
            if (arcoHijo.getVerticeDestino() == verticeId2)
                return arcoHijo;
        }
        return null;
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
        return vertices.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        Iterator<Arco<T>> itArcosDeOrigen = vertices.get(verticeId).iterator();
        ArrayList<Integer> verticesAdyacentes = new ArrayList<>();
        while (itArcosDeOrigen.hasNext())
            verticesAdyacentes.add(itArcosDeOrigen.next().getVerticeDestino());
        return verticesAdyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> arcos = new ArrayList<>();
        vertices.forEach((key, value) -> {
            arcos.addAll(vertices.get(key));
        });
        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return vertices.get(verticeId).iterator();
    }
}