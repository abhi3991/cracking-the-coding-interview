package arraysandstrings;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.PrintUtils.print;

public class PalindromePermutation {

    public static boolean isPermutationAPalindrome(String s) {

        Set<Character> tracker = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (tracker.contains(c)) {
                tracker.remove(c);
            } else if (c != ' ') {
                tracker.add(c);
            }
        }
        return tracker.isEmpty() || tracker.size() == 1;
    }

    public static void main(String[] args) {
        print(PalindromePermutation.class.getName());
        print((List<String> inputs) -> isPermutationAPalindrome(inputs.get(0)), "tact coa");
    }
}
