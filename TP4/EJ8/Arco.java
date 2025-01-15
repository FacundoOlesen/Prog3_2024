package TP4.EJ8;

/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arco<T> {

    private T verticeOrigen;
    private T verticeDestino;
    private Integer etiqueta;

    public Arco(T verticeOrigen, T verticeDestino, Integer etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public T getVerticeOrigen() {
        return verticeOrigen;
    }

    public T getVerticeDestino() {
        return verticeDestino;
    }

    public Integer getEtiqueta() {
        return etiqueta;
    }

    @Override
    public String toString() {
        return "Arco{" +
                "verticeOrigen=" + verticeOrigen +
                ", verticeDestino=" + verticeDestino +
                ", etiqueta=" + etiqueta +
                '}';
    }

}
