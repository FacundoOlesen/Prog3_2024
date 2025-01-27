package TP4.EJ1;

import java.util.Iterator;

public class IteradorArcos<T> implements Iterator<T> {
    private Iterator<Arco<T>> itArcos;

    public IteradorArcos(Iterator<Arco<T>> itArcos) {
        this.itArcos = itArcos;
    }

    @Override
    public boolean hasNext() {
        return itArcos.hasNext();
    }

    @Override
    public T next() {
        return itArcos.next().getVerticeDestino();
    }
}
