package TP4.EJ1;


import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {
    private int cantVertices = 0;
    private int cantArcos = 0;
    private HashMap<T, LinkedList<Arco<T>>> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(T verticeId) {  //0(1)
        if (!this.contieneVertice(verticeId)) {
            vertices.put(verticeId, new LinkedList<Arco<T>>());
            cantVertices++;
        }
    }

    @Override
    public void borrarVertice(T verticeId) { //O(N+M) = O(N)
        if (this.contieneVertice(verticeId)) {
            vertices.forEach((key, value) -> {
                Iterator<Arco<T>> itArcos = value.iterator();
                while (itArcos.hasNext()) {
                    Arco<T> arquito = itArcos.next();
                    if (arquito.getVerticeDestino() == verticeId) {
                        value.remove(arquito); //ARREGLAR ESTO Q EL REMOVE RECORRE TODO PARA ENCONTRAR EL ELEMENTO
                        cantArcos--;
                    }
                }
            });
            vertices.remove(verticeId);
            cantVertices--;
        }
    }

    @Override
    public  void agregarArco(T verticeId1, T verticeId2, T etiqueta) { //O(1)
        if (vertices.get(verticeId1) != null && vertices.get(verticeId2) != null) {
            LinkedList<Arco<T>> arcosDeOrigen = vertices.get(verticeId1);
            arcosDeOrigen.add(new Arco(verticeId1, verticeId2, etiqueta));

            vertices.put(verticeId1, arcosDeOrigen);
            cantArcos++;
        }
    }

    @Override
    public void borrarArco(T verticeId1, T verticeId2) { //O(M)
        LinkedList<Arco<T>> arcosDeOrigen = vertices.get(verticeId1);
        if (arcosDeOrigen != null) {
            Iterator<Arco<T>> itArcos = arcosDeOrigen.iterator();
            while (itArcos.hasNext()) {
                Arco<T> next = itArcos.next();
                if (next.getVerticeDestino() == verticeId2) {
                    arcosDeOrigen.remove(next); //ARREGLAR ESTO Q EL REMOVE RECORRE TODO PARA ENCONTRAR EL ELEMENTO
                    cantArcos--;
                }
            }
        }
    }

    @Override
    public boolean contieneVertice(T verticeId) { //O(1)
        return vertices.get(verticeId) != null;
    }

    @Override
    public boolean existeArco(T verticeId1, T verticeId2) { //O(M)
        if (contieneVertice(verticeId1)) {
            LinkedList<Arco<T>> arcosDeOrigen = vertices.get(verticeId1);
            Iterator<Arco<T>> itArcos = arcosDeOrigen.iterator();
            while (itArcos.hasNext()) {
                if (itArcos.next().getVerticeDestino() == verticeId2)
                    return true;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(T verticeId1, T verticeId2) { //O(M)
        LinkedList<Arco<T>> arcosDeOrigen = vertices.get(verticeId1);
        if (arcosDeOrigen != null) {
            Iterator<Arco<T>> itArcos = arcosDeOrigen.iterator();
            while (itArcos.hasNext()) {
                Arco<T> next = itArcos.next();
                if (next.getVerticeDestino() == verticeId2)
                    return next;
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() { //O(1)
        return this.cantVertices;
    }

    @Override
    public int cantidadArcos() { //O(1)
        return this.cantArcos;
    }

    @Override
    public Iterator<T> obtenerVertices() { //O(1)
        return vertices.keySet().iterator();
    }

    @Override
    public Iterator<T> obtenerAdyacentes(T verticeId) { //O(1)
        LinkedList<Arco<T>> arcosAdyacentes = new LinkedList<>(this.vertices.get(verticeId));
        return new IteradorArcos(arcosAdyacentes.iterator());
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() { //O(N^2)
        ArrayList<Arco<T>> arcos = new ArrayList<>();
        vertices.forEach((key, value) -> {
            arcos.addAll(vertices.get(key));
        });
        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(T verticeId) { //O(1)
        if (contieneVertice(verticeId))
            return vertices.get(verticeId).iterator();
        else { //ESTO X SI ME PASAN UN VERTICE QUE NO EXISTE
            LinkedList<Arco<T>> aux = new LinkedList<>();
            return aux.iterator();
        }
    }
}