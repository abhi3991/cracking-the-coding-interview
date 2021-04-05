package linkedlists;

import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.Iterator;

@ToString
@Getter
public class LinkedList<T> {

    private Node<T> head;

    public LinkedList(T data) {
        this.head = new Node<>(data);
    }

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public LinkedList(Collection<T> dataItems) {
        Iterator<T> dataIterator = dataItems.iterator();
        if (dataIterator.hasNext()) {
            this.head = new Node<>(dataIterator.next());
            Node<T> current = this.head;
            while (dataIterator.hasNext()) {
                current.next = new Node<>(dataIterator.next());
                current = current.next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.head != null) {
            sb.append(this.head.data);
            Node<T> current = this.head.next;
            while (current != null) {
                sb.append(" -> ");
                sb.append(current.data);
                current = current.next;
            }
        }
        return sb.toString();
    }
}
