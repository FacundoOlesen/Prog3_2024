package TP3.EJ1;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();


        /*
        tree.add(6);
        tree.add(10);
        tree.add(12);
        tree.add(9);
        tree.add(25);
        tree.add(23);
        tree.add(28);
        //tree.add(21);*/

         /*tree.add(10);
        tree.add(5);
        tree.add(2);
        tree.add(30);
        tree.add(25);
        tree.add(45);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(55);
        tree.add(54);
        tree.add(56);
        tree.add(50);
        tree.add(51);*/

        tree.add(6);
        tree.add(4);
        tree.add(2);
        tree.add(5);
        tree.add(12);


        /*tree.add(6);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(7);
        tree.add(9);
        tree.add(8);
        tree.add(10);
        tree.add(11);*/


        //tree.add(9);

        System.out.println("RAIZ DEL ARBOL: " + tree.getRoot());
        System.out.println("¿ESTA VACIO?: " + tree.isEmpty());
        System.out.println("ESTA EL NUM? " + tree.hasElem(3));
        System.out.println("ELIMINADO: " + tree.delete(4));
        //System.out.println(tree.getHeight(tree.getRootNode()));
        tree.print2D(tree.getRootNode());
    }
}