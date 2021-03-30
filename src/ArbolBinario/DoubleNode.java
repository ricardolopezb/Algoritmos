package ArbolBinario;

public class DoubleNode<T> {

    T data;
    DoubleNode left;
    DoubleNode right;

    public DoubleNode() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public DoubleNode(T element) {
        this.data = element;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public DoubleNode getLeft() {
        return left;
    }

    public DoubleNode getRight() {
        return right;
    }

    public boolean isEmpty() {
        return data.equals(null);
    }
}
