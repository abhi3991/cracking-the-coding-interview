package arraysandstrings;

import java.util.List;
import java.util.function.Function;

import static utils.PrintUtils.print;

public class StringRotation {
    public static boolean isSubstring(String s1, String s2) {
        if (s1.length() == s2.length()) {
            String attached = s1 + s1;
            return attached.contains(s2);
        }
        return false;
    }

    public static void main(String[] args) {
        Function<List<String>, Boolean> toExec = (inputs) -> isSubstring(inputs.get(0), inputs.get(1));
        print(StringRotation.class.getName());

        print(toExec, "waterbottle", "erbottleaat");
        print(toExec, "waterbottle", "erbottlewat");
    }
}
