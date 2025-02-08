package Practicando.Finales;

public class Caja {
    private String nombre;
    private int resistencia;
    private int peso;

    public Caja(String nombre, int resistencia, int peso) {
        this.nombre = nombre;
        this.resistencia = resistencia;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
