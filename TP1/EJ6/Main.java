package TP1.EJ6;


public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> lista1 = new MySimpleLinkedList<>();
        lista1.insertFront(20);
        lista1.insertFront(17);
        lista1.insertFront(14);
        lista1.insertFront(10);
        lista1.insertFront(9);


        MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<>();
        lista2.insertFront(23);
        lista2.insertFront(20);
        lista2.insertFront(11);
        lista2.insertFront(10);
        lista2.insertFront(7);


        MySimpleLinkedList<Integer> salida = new MySimpleLinkedList<>();

        MyIterator<Integer> it1 = lista1.iterator();
        MyIterator<Integer> it2 = lista2.iterator();


        //COMPLEJIDAD O(2*N) === O(n)
        while (it1.hasNext() && it2.hasNext()) {
            int val1 = it1.get();
            int val2 = it2.get();

            if (val1 < val2) {
                it1.next();
                salida.insertFront(val1);
            }

            if (val2 < val1)
                it2.next();

            if (val1 == val2) {
                it1.next();
                it2.next();
            }
        }
        while (it1.hasNext()) {
            int val = it1.next();
            salida.insertFront(val);
        }

        System.out.println(salida);
    }


}
