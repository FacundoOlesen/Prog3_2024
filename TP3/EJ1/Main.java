package TP3.EJ1;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
     /*   tree.add(6);
        tree.add(2);
        tree.add(8);
        tree.add(1);
        tree.add(4);
        tree.add(3);
        tree.add(7);*/

        tree.add(10);
        tree.add(5);
        tree.add(2);
        tree.add(30);
        tree.add(25);
        tree.add(45);
        tree.add(8);
        tree.add(7);
        tree.add(55);


        System.out.println("RAIZ DEL ARBOL: " + tree.getRoot());
        System.out.println("¿ESTA VACIO?: " + tree.isEmpty());
        System.out.println("ESTA EL NUM? " + tree.hasElem(tree.getRootNode(), 25));
        System.out.println("ELIMINADO: " + tree.delete(tree.getRootNode(), 45));
        tree.print2D(tree.getRootNode());
    }
}
