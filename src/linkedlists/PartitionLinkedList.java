package linkedlists;

import java.util.Arrays;
import java.util.List;

import static utils.PrintUtils.print;

public class PartitionLinkedList {
    public static LinkedList<Integer> partitionLinkedList(LinkedList<Integer> linkedList, int partition) {
        Node<Integer> firstLLHead, secondLLHead;
        firstLLHead = secondLLHead = null;
        Node<Integer> firstLLCurrent, secondLLCurrent;
        firstLLCurrent = secondLLCurrent = null;

        Node<Integer> current = linkedList.getHead();

        while (current != null) {
            if (current.data < partition) {
                if (firstLLHead == null) {
                    firstLLHead = new Node<>(current.data);
                    firstLLCurrent = firstLLHead;
                } else {
                    firstLLCurrent = append(firstLLCurrent, current.data);
                }
            } else {
                if (secondLLHead == null) {
                    secondLLHead = new Node<>(current.data);
                    secondLLCurrent = secondLLHead;
                } else {
                    secondLLCurrent = append(secondLLCurrent, current.data);
                }
            }
            current = current.next;
        }
        
        if (firstLLHead != null) {
            firstLLCurrent.next = secondLLHead;
            return new LinkedList<>(firstLLHead);
        } else {
            return new LinkedList<>(secondLLHead);
        }
    }

    private static Node<Integer> append(Node<Integer> current, int data) {
        current.next = new Node<>(data);
        return current.next;
    }

    public static void main(String[] args) {
        print(PartitionLinkedList.class.getName());

        List<Integer> input = Arrays.asList(1, 8, 5, 10, 2, 1, 3, 12);
        LinkedList<Integer> inputLL = new LinkedList<>(input);
        int partition = 5;

        print("input");
        print("linked list before partition", inputLL, "|", "partition", partition);

        LinkedList<Integer> outputLL = partitionLinkedList(inputLL, partition);

        print("output");
        print("linked list after partition", outputLL);
    }

}
