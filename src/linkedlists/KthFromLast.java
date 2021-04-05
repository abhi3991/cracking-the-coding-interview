package linkedlists;

import java.util.Arrays;
import java.util.List;

import static utils.PrintUtils.execAndPrint;
import static utils.PrintUtils.print;

public class KthFromLast {

    public static  <T> Node<T> kthFromLast(LinkedList<T> linkedList, int k) {
        Node<T> p1, p2;
        p1 = p2 = linkedList.getHead();

        for (int i = 0; i < k; i++) {
            if (p1.next != null) {
                p1 = p1.next;
            }
        }

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    public static void main(String[] args) {
        print(KthFromLast.class.getName());

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);

        LinkedList<Integer> inputLL = new LinkedList<>(input);

        for (int i = 0; i < 5; i++) {
            final int k = i;
            print("input");
            print("k", k, " | ", "linked list", inputLL);
            execAndPrint(() -> kthFromLast(inputLL, k));
        }
    }

}
