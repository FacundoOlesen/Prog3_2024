package TP4;

import java.util.HashMap;

public class Vertice<T> {
    private int verticeId;
    private int index = 0;
    private HashMap<Integer, Arco<T>> arcos;

    public Vertice(int verticeId, HashMap<Integer, Arco<T>> arcos) {
        this.verticeId = verticeId;
        this.arcos = arcos;
    }

    public void addArco(Arco<T> arco) {
        arcos.put(index, arco);
        index++;
    }

    public void borrarArco(Arco<T> arco) {
        arcos.remove(arco);
    }

    public Arco<T> getArco(int verticeDestino) {
        for (int i = 0; i < arcos.size(); i++) {
            Arco<T> arcoHijo = arcos.get(i);
            if (arcoHijo.getVerticeDestino() == verticeDestino) {
                return arcoHijo;
            }
        }
        return null;
    }

    public boolean existeArco(int verticeDestino) {
        for (int i = 0; i < arcos.size(); i++) {
            if (arcos.get(i).getVerticeDestino() == verticeDestino)
                return true;
        }
        return false;
    }

    public Arco<T> obtenerArco(int verticeDestino) {
        for (int i = 0; i < arcos.size(); i++) {
            Arco<T> arcoHijo = arcos.get(i);
            if (arcoHijo.getVerticeDestino() == verticeDestino)
                return arcoHijo;
        }
        return null;
    }
}