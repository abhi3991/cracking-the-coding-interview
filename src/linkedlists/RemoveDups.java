package linkedlists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.PrintUtils.execAndPrint;
import static utils.PrintUtils.print;

public class RemoveDups {

    public static <T> LinkedList<T> removeDups(LinkedList<T> linkedList) {
        if (linkedList != null) {
            Node<T> current = linkedList.getHead();
            while (current != null) {
                Node<T> runner = current;
                while (runner != null && runner.next != null) {
                    if (current.data.equals(runner.next.data)) {
                        runner.next = (runner.next.next != null) ? runner.next.next : null;
                    }
                    runner = runner.next;
                }
                current = current.next;
            }
        }
        return linkedList;
    }

    public static <T> LinkedList<T> removeDupsFast(LinkedList<T> linkedList) {
        if (linkedList != null) {
            Set<T> tracker = new HashSet<>();
            Node<T> current = linkedList.getHead();
            tracker.add(current.data);
            while (current.next != null) {
                if (tracker.contains(current.next.data)) {
                    current.next = current.next.next;
                } else {
                    tracker.add(current.next.data);
                    current = current.next;
                }
            }
        }
        return linkedList;
    }

    public static void main(String[] args) {
        print(RemoveDups.class.getName());
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 2, 4, 2, 1, 3);

        LinkedList<Integer> input = new LinkedList<>(inputList);
        LinkedList<Integer> inputFast = new LinkedList<>(inputList);

        print("without extra buffer");
        execAndPrint(() -> removeDups(input), input);
        print("with buffer");
        execAndPrint(() -> removeDupsFast(inputFast), inputFast);
    }

}
