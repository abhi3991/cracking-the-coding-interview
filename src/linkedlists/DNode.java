package linkedlists;

public class DNode<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    public DNode(T data) {
        this.data = data;
        next = prev = null;
    }
}
