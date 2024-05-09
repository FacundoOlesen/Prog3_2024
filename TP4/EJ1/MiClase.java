package TP4.EJ1;

import java.util.ArrayList;
import java.util.HashMap;

class MiClase {
    private int id;

    public MiClase(int id) {
        this.id = id;
    }

    // Implementación de hashCode()
    @Override
    public int hashCode() {
        return id;
    }

    // Implementación de equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MiClase otra = (MiClase) obj;
        return id == otra.id;
    }


    public static void main(String[] args) {
        HashMap<MiClase, ArrayList<String>> mapa = new HashMap<>();

        MiClase clave1 = new MiClase(1);
        MiClase clave2 = new MiClase(2);

        // Creamos y agregamos elementos a los ArrayList
        ArrayList<String> lista1 = new ArrayList<>();
        lista1.add("Elemento1");
        lista1.add("Elemento2");

        ArrayList<String> lista2 = new ArrayList<>();
        lista2.add("Elemento3");
        lista2.add("Elemento4");

        // Asociamos los ArrayList con las claves correspondientes en el HashMap
        mapa.put(clave1, lista1);
        mapa.put(clave2, lista2);

        ArrayList<String> x = mapa.get(clave1);

        // Obtener valores
        System.out.println(mapa.get(clave1)); // Imprime: [Elemento1, Elemento2]
        System.out.println(mapa.get(clave2)); // Imprime: [Elemento3, Elemento4]
    }
}
