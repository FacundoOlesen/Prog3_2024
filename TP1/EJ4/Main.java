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

        Iterator<Integer> it = lista.iterator();

        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println(i);
        }

        /*for (Integer i : lista) {
            System.out.println(i);
        }*/


    }
}
