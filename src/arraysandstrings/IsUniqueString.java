package arraysandstrings;

import java.util.List;
import java.util.function.Function;

import static utils.PrintUtils.execAndPrint;
import static utils.PrintUtils.print;

public class IsUniqueString {

    private static boolean isUnique(final String input) {
        final boolean[] charTracker = new boolean[128];
        for (char c : input.toCharArray()) {
            if (!charTracker[c]) {
                charTracker[c] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Function<List<String>, Boolean> toExec = (input) -> isUnique(input.get(0));
        print(IsUniqueString.class.getName());

        execAndPrint(toExec, "abcc");
        execAndPrint(toExec, "abcdefghijklmnopqrstuvwxyz");
        execAndPrint(toExec, "a");
    }

}
