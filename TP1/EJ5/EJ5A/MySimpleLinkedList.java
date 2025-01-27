package TP1.EJ5.EJ5A;


import java.util.Collections;
import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, null);
        tmp.setNext(this.first);
        this.first = tmp;
        size++;
    }

    public T extractFront() {
        Node<T> tmp = this.first;
        this.first = tmp.getNext();
        size--;
        return tmp.getInfo();
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T get(int index) {
        Node<T> tmp = this.first;
        for (int i = 0; i < index; i++)
            tmp = tmp.getNext();
        return tmp.getInfo();
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String res = " ";
        int i = 0;
        Node<T> tmp = this.first;
        while (i < size) {
            res += tmp.getInfo() + ",";
            tmp = tmp.getNext();
            i++;
        }
        return res;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    //3
    public int indexOf(T info) {
        int i = 0;
        Node<T> tmp = this.first;
        while (i < size && tmp.getInfo() != info) {
            tmp = tmp.getNext();
            i++;
        }
        if (i <= size) return i;
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(this.first);
    }


    public void buscoYAgrego(MySimpleLinkedList<T> listaAComparar, MySimpleLinkedList<T> listaResultante) {
        for (T i : this) {
            if (buscar(i, listaAComparar))
                listaResultante.insertFront(i);
        }
        bubbleSortAdapt(listaResultante);
    }

    public void bubbleSortAdapt(TP1.EJ5.EJ5A.MySimpleLinkedList<T> listaResultante) {
        boolean swapped = true;
        int j = 0;
        T tmp;
        TP1.EJ5.EJ5A.Node<T> actual = listaResultante.getFirst();
        while (swapped) {
            swapped = false;
            for (int i = 0; i < size; i++) {
                actual = listaResultante.getFirst();
                while (actual.getNext() != null) {
                    if (actual.getInfo().compareTo(actual.getNext().getInfo()) > 0) {
                        tmp = actual.getInfo();
                        actual.setInfo(actual.getNext().getInfo());
                        actual.getNext().setInfo(tmp);
                        swapped = true;
                    }
                    actual = actual.getNext();
                }
            }
        }
    }


    public boolean buscar(T num, MySimpleLinkedList<T> lista) {
        int i = 0;
        Node<T> tmp = lista.getFirst();
        while (i < lista.size() && num != tmp.getInfo()) {
            tmp = tmp.getNext();
            i++;
        }
        return (i < lista.size());
    }
}
