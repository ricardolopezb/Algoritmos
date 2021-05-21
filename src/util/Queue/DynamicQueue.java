package util.Queue;

import util.*;

public class DynamicQueue<T> implements Queue<T> {
    //nodo centinela y nodo cabecera buscar
    private Node first;
    private Node last;
    private int size;

    public DynamicQueue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public void enqueue(T element) {
        if(isEmpty()){
            last = new Node(element);
            first = last;

        } else {
            Node aux = new Node(element);
            last.setPointer(aux);
            last = aux;
        }
        size++;
    }

    @Override
    public T dequeue() throws IsEmptyException {

        if(isEmpty()) throw new IsEmptyException();

        T toReturn = (T) first.getData();
        first = first.getPointer();
        size--;
        return toReturn;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }
}
