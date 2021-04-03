package util;

public class Node<T> {

    private T data;
    private Node pointer;

    public Node() {
        this.data = null;
        this.pointer = null;
    }

    public Node(T object){
        this.data = object;
        this.pointer = null;
    }

    public Node(T object, Node pointer){
        this.data = object;
        this.pointer = pointer;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getPointer() {
        return pointer;
    }

    public void setPointer(Node pointer) {
        this.pointer = pointer;
    }
}
