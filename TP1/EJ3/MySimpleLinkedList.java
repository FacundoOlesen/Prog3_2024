package TP1.EJ3;

public class MySimpleLinkedList<T> {
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

    //3
    public int indexOf(T info) {
        int i = 0;
        Node<T> tmp = this.first;
        while (i < size && tmp.getInfo() != info) {
            tmp = tmp.getNext();
            i++;
        }
        if (i <= size)
            return i;
        return -1;
    }
}
