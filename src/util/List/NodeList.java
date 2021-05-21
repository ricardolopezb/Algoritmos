package util.List;

/**
 * Created by Oscar on 23/03/2017.
 */
public class NodeList <T> {
    T data;
    NodeList<T> next;

    public NodeList(T data) {
        this.data = data;
    }
}
