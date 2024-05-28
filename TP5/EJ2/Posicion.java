package TP5.EJ2;

public class Posicion {
    private Integer valor;
    private boolean izq;
    private boolean der;
    private boolean arr;
    private boolean abj;

    public Posicion(Integer valor, boolean izq, boolean der, boolean arr, boolean abj) {
        this.valor = valor;
        this.izq = izq;
        this.der = der;
        this.arr = arr;
        this.abj = abj;
    }

    public Integer getValor() {
        return valor;
    }

    public boolean isIzq() {
        return izq;
    }

    public boolean isDer() {
        return der;
    }

    public boolean isArr() {
        return arr;
    }

    public boolean isAbj() {
        return abj;
    }
}
