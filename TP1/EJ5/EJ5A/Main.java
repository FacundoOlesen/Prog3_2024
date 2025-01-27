package TP1.EJ5.EJ5A;


public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> lista1 = new MySimpleLinkedList<>();
        lista1.insertFront(22);
        lista1.insertFront(1);
        lista1.insertFront(44);
        lista1.insertFront(2);
        lista1.insertFront(4);


        MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<>();
        lista2.insertFront(44);
        lista2.insertFront(3);
        lista2.insertFront(22);
        lista2.insertFront(1);
        lista2.insertFront(2);


        /*Iterator<Integer> it1 = lista1.iterator();
        Iterator<Integer> it2 = lista2.iterator();*/

        MySimpleLinkedList<Integer> lista3 = new MySimpleLinkedList<>();
        lista1.buscoYAgrego(lista2, lista3);
        System.out.println(lista3);
    }


}
