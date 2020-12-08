package pkg2020.pkg12.pkg08.examen;

interface Iterador<E> {

    boolean hasNext();

    E next();
}

public class IterEnlazada<E> implements Iterador<E> {

    private Nodo<E> actual;

    public IterEnlazada(Nodo<E> a) {
        actual = a;
    }

    @Override
    public boolean hasNext() {
        return actual.getNext() != null;
    }

    @Override
    public E next() {
        if (hasNext()) {
            actual = actual.getNext();
            return actual.getInfo();
        } else {
            return null;
        }
    }
}
