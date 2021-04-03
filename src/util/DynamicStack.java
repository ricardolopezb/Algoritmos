package util;

import util.*;

public class DynamicStack<T> implements Stack<T> {

    private Node top;
    private int size;

    public DynamicStack() {
        this.top = new Node();
        this.size = 0;
    }

    @Override
    public T peek(){
        return (T) getTop().getData();
    }

    @Override
    public void stack(T element){
        Node<T> aux = new Node();
        aux.setData(element);
        aux.setPointer(getTop());
        setTop(aux);
        ++size;
    }

    @Override
    public void pop() throws IsEmptyException {
        if (!isEmpty()){
            T element = (T) getTop().getData();
            setTop(getTop().getPointer());
            --size;}
        else throw new IsEmptyException();
    }

    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void empty() throws IsEmptyException {
        if (!isEmpty()){
            setTop(null);
            size = 0;
        }
        else throw new IsEmptyException();
    }

    private Node getTop() {
        return top;
    }

    private void setTop(Node top) {
        this.top = top;
    }
}
