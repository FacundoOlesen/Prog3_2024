package TP6.EJ7;

public class Cancion {
    private String nombre;
    private String genero;
    private int duracion;
    private int tamanio;

    public Cancion(String nombre, String genero, int duracion, int tamanio) {
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.tamanio = tamanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", duracion=" + duracion +
                ", tamanio=" + tamanio +
                '}';
    }
}
