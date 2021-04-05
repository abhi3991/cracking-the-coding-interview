package linkedlists;

import java.util.Arrays;
import java.util.List;

import static utils.PrintUtils.execAndPrint;
import static utils.PrintUtils.print;

public class DeleteInputNode {

    // this problem is named Delete Middle Node in CRC.

    public static <T> boolean deleteInputNode(Node<T> nodeToDelete) {

        if (nodeToDelete == null || nodeToDelete.next == null) {
            throw new IllegalArgumentException("Last node shouldn't be deleted");
        }

        Node<T> nextNode = nodeToDelete.next;
        nodeToDelete.next = nextNode.next;
        nodeToDelete.data = nextNode.data;

        return true;
    }

    public static void main(String[] args) {
        print(DeleteInputNode.class.getName());

        List<String> input = Arrays.asList("a", "b", "c", "d", "e", "f");
        LinkedList<String> inputLL = new LinkedList<>(input);

        execAndPrint(() -> deleteInputNode(inputLL.getHead().next.next), inputLL);
        print("Linked List after deletion:", inputLL);
    }
}
