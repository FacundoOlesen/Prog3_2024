package TP3.EJ6;

import java.util.ArrayList;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private ArrayList<String> generos;
    private int anioPublicacion;
    private int cantEjemplares;

    public Libro(int id, String titulo, String autor, int anioPublicacion, int cantEjemplares) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.generos = generos;
        this.anioPublicacion = anioPublicacion;
        this.cantEjemplares = cantEjemplares;
        this.generos = new ArrayList<>();
    }


    public void addGenero(String gen) {
        this.generos.add(gen);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public ArrayList<String> getGeneros() {
        return new ArrayList<>(this.generos);
    }

    public int getId() {
        return id;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getCantEjemplares() {
        return cantEjemplares;
    }

    public void setCantEjemplares(int cantEjemplares) {
        this.cantEjemplares = cantEjemplares;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", generos=" + generos +
                ", anioPublicacion=" + anioPublicacion +
                ", cantEjemplares=" + cantEjemplares +
                '}';
    }
}
