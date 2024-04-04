package TP1.EJ1;

public class Main {
    public static void main(String[] args) {
        Node<Integer> nodo1 = new Node<>(1,null);
        Node<Integer> nodo2 = new Node<>(2,null);

        MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<>();
        lista.insertFront(nodo2.getInfo());
        lista.insertFront(nodo1.getInfo());
        //System.out.println(lista.get(0).getInfo());

        System.out.println(lista.toString());

        System.out.println(lista.get(12));
    }
}
