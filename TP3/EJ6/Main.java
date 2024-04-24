package TP3.EJ6;


public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Libro noMePuedesLastimar = new Libro(15, "No me puedes lastimar", "David Gogins", 2018, 40);
        Libro bioElonMusk = new Libro(3, "Biografia Elon Musk", "Walter Isaacson", 2019, 10);
        Libro doceReglas = new Libro(20, "12 reglas para vivir", "Jordan B. Peterson", 2008, 13);
        Libro cienAnios = new Libro(22, "Cien anios de soledad", "Gabriel Garcia Marquez", 1998, 2);

        noMePuedesLastimar.addGenero("Motivacion");
        bioElonMusk.addGenero("Biografia");
        bioElonMusk.addGenero("Motivacion");
        doceReglas.addGenero("Psicologia");
        cienAnios.addGenero("Ciencia Ficcion");

        tree.add(noMePuedesLastimar);
        tree.add(bioElonMusk);
        tree.add(doceReglas);
        tree.add(cienAnios);

        System.out.println(tree.getCantEjemplares(22));
        System.out.println(tree.getLibrosByGenero("Motivacion"));
        System.out.println(tree.getLibrosEntreAnios(2017, 2020));

    }
}
