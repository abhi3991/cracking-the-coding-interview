package arraysandstrings;

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
        print("abcc", isUnique("abcc") + "");
        print("abcdefghijklmnopqrstuvwxyz", isUnique("abcdefghijklmnopqrstuvwxyz") + "");
        print("a", isUnique("a") + "");
    }

    public static void print(String input, String output) {
        System.out.println(input + ": " + output);
    }
}
