package TP4.EJ1;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Integer> grafito = new GrafoDirigido<>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);


        // Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
        grafito.agregarArco(1, 2, 3);
        grafito.agregarArco(1, 3, 5);
        grafito.agregarArco(2, 1, 5);
        grafito.agregarArco(12, 1, 5);

        System.out.println("OBTENGO ARCO: " + grafito.obtenerArco(1, 3));
        //grafito.borrarVertice(1);
        grafito.borrarVertice(321);

        //grafito.borrarArco(1, 2);
        // Obtengo el arco entre 1 y 2, y le pido la etiqueta


        System.out.println("CONTIENE VERTICE?: " + grafito.contieneVertice(1));
        System.out.println("EXISTE ARCO?: " + grafito.existeArco(1, 3));
        System.out.println("OBTENGO ARCO: " + grafito.obtenerArco(1, 2));


        System.out.println("OBTENGO TODOS LOS VERTICES: ");
        Iterator<Integer> itVertices = grafito.obtenerVertices();
        while (itVertices.hasNext())
            System.out.println(itVertices.next());

        System.out.println("OBTENGO TODOS LOS ADYACENTES DE 1: ");
        Iterator<Integer> itAdyacentes = grafito.obtenerAdyacentes(1);
        while (itAdyacentes.hasNext())
            System.out.println(itAdyacentes.next());

        System.out.println("OBTENGO TODOS LOS ARCOS: ");
        Iterator<Arco<Integer>> itArcos = grafito.obtenerArcos();
        while (itArcos.hasNext())
            System.out.println(itArcos.next());

        System.out.println("OBTENGO TODOS LOS ARCOS DESDE VERTICE: ");
        Iterator<Arco<Integer>> itArcosDesdeVertice = grafito.obtenerArcos(1);
        while (itArcosDesdeVertice.hasNext())
            System.out.println(itArcosDesdeVertice.next());



    }
}