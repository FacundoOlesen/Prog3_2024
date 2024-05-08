package TP4;


import java.util.ArrayList;

public class Vertice<T> {
    private int verticeId;
    private ArrayList<Arco<T>> arcos;

    public Vertice(int verticeId) {
        this.verticeId = verticeId;
        this.arcos = new ArrayList<>();
    }

    public int getVerticeId() {
        return verticeId;
    }

    public ArrayList<Arco<T>> getArcos() {
        return new ArrayList<>(this.arcos);
    }

    public void addArco(Arco<T> arco) {
        arcos.add(arco);
    }

    public void borrarArco(int verticeDestino) {
        for (int i = 0; i < arcos.size(); i++) {
            Arco<T> arcoHijo = arcos.get(i);
            if (arcoHijo.getVerticeDestino() == verticeDestino) {
                arcos.remove(i);
            }
        }
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

    public void borrarTodosLosArcos() {
        this.arcos.clear();
    }
}