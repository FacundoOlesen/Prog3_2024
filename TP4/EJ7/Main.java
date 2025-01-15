package TP4.EJ7;

import TP4.EJ1.GrafoNoDirigido;
import TP4.EJ5.CaminosDesdeOrigenADestino;
import TP4.EJ6.CaminoMasCortoEntreDosEsquinas;

public class Main {
    public static void main(String[] args) {
        GrafoNoDirigido<String> grafoCiudades = new GrafoNoDirigido<>();
      /*  grafoCiudades.agregarVertice(1); //BUENOS AIRES
        grafoCiudades.agregarVertice(2); //CANUELAS
        grafoCiudades.agregarVertice(3); //MONTE
        grafoCiudades.agregarVertice(4); //LAS FLORES
        grafoCiudades.agregarVertice(5); //RAUCH
        grafoCiudades.agregarVertice(6); //TANDIL

        grafoCiudades.agregarVertice(7); //AZUL
        grafoCiudades.agregarVertice(8); //TRES ARROYOS
        grafoCiudades.agregarVertice(9); //BOLIVAR
        grafoCiudades.agregarVertice(10); //LOBERIA
        grafoCiudades.agregarVertice(11); //BARKER


        grafoCiudades.agregarArco(1, 2, "BS.AS-CANUELAS");
        grafoCiudades.agregarArco(2, 3, "CANUELAS-MONTE");
        grafoCiudades.agregarArco(3, 4, "MONTE-LAS FLORES");
        grafoCiudades.agregarArco(4, 5, "LAS FLORES-RAUCH");
        grafoCiudades.agregarArco(5, 6, "RAUCH-TANDIL");

        grafoCiudades.agregarArco(1, 7, "BS.AS-AZUL");
        grafoCiudades.agregarArco(8, 9, "TS.AS-BOLIVAR");
        grafoCiudades.agregarArco(10, 11, "LOBERIA-BARKER");
        grafoCiudades.agregarArco(6, 8, "TANDIL-TS.AS");
        grafoCiudades.agregarArco(6, 9, "TANDIL-BOLIVAR");
        grafoCiudades.agregarArco(6, 11, "TANDIL-BARKER");*/

        grafoCiudades.agregarVertice("Tandil");
        grafoCiudades.agregarVertice("Las Flores");
        grafoCiudades.agregarVertice("Rauch");
        grafoCiudades.agregarVertice("Mar del Plata");
        grafoCiudades.agregarVertice("Buenos Aires");

        grafoCiudades.agregarArco("Tandil", "Las Flores", "Tandil-Las Flores");
        grafoCiudades.agregarArco("Rauch", "Mar del Plata", "Rauch-Mar del Plata");
        grafoCiudades.agregarArco("Buenos Aires", "Las Flores", "Buenos Aires-Las Flores");


        CaminosDesdeOrigenADestino camino = new CaminosDesdeOrigenADestino(grafoCiudades);
        System.out.println(camino.obtenerCaminosDeOrigenADestino("Tandil", "Buenos Aires", "Buenos Aires", "Las Flores"));
    }
}
