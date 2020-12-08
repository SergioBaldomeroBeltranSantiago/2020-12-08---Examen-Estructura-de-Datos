package pkg2020.pkg12.pkg08.examen;

class PosicIncE extends Exception {

}

class ElemNoEncE extends Exception {

}

interface Lista<E> {

    void add(int index, E element) throws PosicIncE;

    void add(E element);

    E remove(int index) throws ElemNoEncE, PosicIncE;

    boolean contains(E x);

    E get(int index) throws PosicIncE;

    int getIndex(E x);

    void set(int index, E element) throws PosicIncE;

    void clear();

    Iterador iter();

    int size();

    boolean isEmpty();

}

public class ListaEnlazada<E> implements Lista<E> {

    private Nodo<E> head;

    public ListaEnlazada() {
        head = new Nodo<>(null, null);
    }

    @Override
    public void add(E x) {
        Nodo<E> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        Nodo<E> newNodo = new Nodo<>(x);
        temp.setNext(newNodo);
    }

    private Nodo caminar(int index) {
        Nodo<E> temp = head;
        int i = 1;
        while (i < index) {
            i++;
            temp = temp.getNext();
        }
        return temp;
    }

    @Override
    public void add(int index, E x) throws PosicIncE {
        if (1 <= index && index <= size()) {
            Nodo<E> temp = caminar(index);
            Nodo<E> newNodo = new Nodo<>(x);
            newNodo.setNext(temp.getNext());
            temp.setNext(newNodo);
        } else {
            throw new PosicIncE();
        }
    }

    @Override
    public int size() {
        int i = 0;
        Nodo<E> tmp = head.getNext();
        while (tmp != null) {
            tmp = tmp.getNext();
            i++;
        }
        return i;
    }

    public void remove(E x) throws ElemNoEncE {
        Nodo<E> tmp = head.getNext();
        Nodo<E> tmpa = head;
        while (tmp != null && !tmp.getInfo().equals(x)) {
            tmpa = tmp;
            tmp = tmp.getNext();
        }
        if (tmp == null) // no se encontró
        {
            throw new ElemNoEncE();
        } else {
            tmpa.setNext(tmp.getNext());
        }
    }

    @Override
    public boolean contains(E x) {
        Nodo<E> tmp = head.getNext();
        while (tmp != null && !tmp.getInfo().equals(x)) {
            tmp = tmp.getNext();
        }
        return tmp != null;
    }

    @Override
    public E get(int index) throws PosicIncE {
        if (1 <= index && index <= size()) {
            Nodo<E> tmp = caminar(index);
            E o = tmp.getNext().getInfo();
            return o;
        } else {
            throw new PosicIncE();
        }
    }

    @Override
    public int getIndex(E x) {
        int i = 1;
        Nodo<E> tmp = head.getNext();
        while (tmp != null && !tmp.getInfo().equals(x)) {
            tmp = tmp.getNext();
            i++;
        }
        return ((tmp != null) ? i : -1);
    }

    @Override
    public void clear() {
        head.setNext(null);
    }

    @Override
    public Iterador<E> iter() {
        Iterador<E> it = new IterEnlazada<>(head);
        return it;
    }

    @Override
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    @Override
    public void set(int index, E element) throws PosicIncE {
        if (1 <= index && index <= size()) {
            Nodo<E> tmp = caminar(index);
            tmp.getNext().setInfo(element);
        } else {
            throw new PosicIncE();
        }
    }

    @Override
    public E remove(int index) throws ElemNoEncE, PosicIncE {
        if (1 <= index && index <= size()) {
            Nodo<E> temp = caminar(index);
            E elem = temp.getNext().getInfo();
            temp.setNext(temp.getNext().getNext());
            return elem;
        } else {
            throw new PosicIncE();
        }
    }

}
