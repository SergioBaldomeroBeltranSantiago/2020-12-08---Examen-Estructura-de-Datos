package pkg2020.pkg12.pkg08.examen;

public class Nodo<E> {

    private E info;
    private Nodo<E> next;

    public Nodo(E info, Nodo<E> next) {
        this.info = info;
        this.next = next;
    }

    public Nodo(E info) {
        this(info, null);
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Nodo<E> getNext() {
        return next;
    }

    public void setNext(Nodo<E> next) {
        this.next = next;
    }

}
