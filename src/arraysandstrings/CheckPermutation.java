package arraysandstrings;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static utils.PrintUtils.print;

public class CheckPermutation {

    public static boolean isValidPermutation(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);

        return new String(s1Arr).equals(new String(s2Arr));
    }

    public static void main(String[] args) {
        Function<List<String>, Boolean> toExec = (inputs) -> isValidPermutation(inputs.get(0), inputs.get(1));
        print(CheckPermutation.class.getName());
        print(toExec, "abc", "cba");
        print(toExec, "absdaf", "fabsda");
        print(toExec, "absdaf", "fabsdae");
    }
}
