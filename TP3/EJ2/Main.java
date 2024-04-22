package TP3.EJ2;


public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(6);
        tree.add(2);
        tree.add(4);
        tree.add(5);
        tree.add(1);
        tree.add(15);
        tree.add(14);
        tree.add(16);

        System.out.println("LA SUMA DE LOS NODOS INTERNOS ES: " + tree.sumaNodosInternos());
    }
}
