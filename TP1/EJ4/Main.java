package TP1.EJ4;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<>();

        lista.insertFront(22);
        lista.insertFront(12);
        lista.insertFront(1);
        lista.insertFront(8);
        lista.insertFront(7);

        //O(size^2)
        for (int i = 0; i < lista.size(); i++) { // O(size)
            Integer elem = lista.get(i); // O(size)
            System.out.println(elem);
        }


        Iterator<Integer> it = lista.iterator();

        while (it.hasNext()) { //O(size)
            Integer i = it.next(); //O(1)
            System.out.println(i); //O(1)
        }

        //HACE LO MISMO QUE ARRIBA (EL ITERATOR)
        for (Integer i : lista) {
            System.out.println(i);
        }


    }
}
