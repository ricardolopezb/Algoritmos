package util;


public interface Stack<T> {

    boolean isEmpty();
    T peek();
    void pop() throws IsEmptyException;
    void stack(T element);
    int size();
    void empty() throws IsEmptyException;
}
