package util.Queue;


import util.IsEmptyException;

public interface Queue<T> {

    void enqueue(T element);
    T dequeue() throws IsEmptyException;
    boolean isEmpty();
    int size();
}
