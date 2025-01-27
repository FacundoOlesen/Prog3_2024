import TP6.EJ7.Cancion;
import TP6.EJ7.Disco;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cancion> canciones = List.of(
                new Cancion("Song A", "Rock", 300, 4000),
                new Cancion("Song B", "Pop", 250, 3000),
                new Cancion("Song C", "Rock", 200, 3500),
                new Cancion("Song D", "Jazz", 180, 2000),
                new Cancion("Song E", "Pop", 270, 2500),
                new Cancion("Song F", "Rock", 320, 5000),
                new Cancion("Song G", "Jazz", 220, 1500)
        );

        int capacidadMaxima = 15000;

        Disco disco = new Disco(canciones);

        System.out.println("Canciones seleccionadas:");
        List<Cancion> seleccionadas = disco.greedy(capacidadMaxima);
        for (Cancion c : seleccionadas) {
            System.out.println(c);
        }
    }
}