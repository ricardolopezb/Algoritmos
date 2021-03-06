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

    public DoubleNode(T data,DoubleNode<T> left,DoubleNode<T> right){
        this.data=data;
        this.right=right;
        this.left=left;
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
        return data == null;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(DoubleNode left) {
        this.left = left;
    }

    public void setRight(DoubleNode right) {
        this.right = right;
    }
}
