package TP4.EJ1;


import java.util.ArrayList;
import java.util.Objects;

public class Vertice<T> {
    private int verticeId;


    public Vertice(int verticeId) {
        this.verticeId = verticeId;
    }

    public int getVerticeId() {
        return verticeId;
    }

    @Override
    public int hashCode() {
        return verticeId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertice otra = (Vertice) obj;
        return this.getVerticeId() == otra.getVerticeId();
    }
}