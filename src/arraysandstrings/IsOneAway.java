package arraysandstrings;

import java.util.List;
import java.util.function.Function;

import static utils.PrintUtils.print;

public class IsOneAway {

    public static boolean isOneAway(String s1, String s2) {

        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        int totalEdits = 0;

        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    totalEdits++;
                }
                if (totalEdits > 1) {
                    return false;
                }
            }
            return true;
        }

        totalEdits = 0;
        String bigger = s1.length() > s2.length() ? s1 : s2;
        String smaller = s1.length() < s2.length() ? s1 : s2;
        int i = 0, j = 0;
        while (i < bigger.length() && j < smaller.length()) {
            if (bigger.charAt(i) != smaller.charAt(j)) {
                i++;
                totalEdits++;
            } else {
                i++;
                j++;
            }
            if (totalEdits > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Function<List<String>, Boolean> toExec = (inputs) -> isOneAway(inputs.get(0), inputs.get(1));
        print(IsOneAway.class.getName());

        print(toExec, "pale", "ple");
        print(toExec, "pale", "ale");
        print(toExec, "pales", "pale");
        print(toExec, "pale", "bale");
        print(toExec, "pale", "bake");
    }
}
