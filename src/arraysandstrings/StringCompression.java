package arraysandstrings;

import java.util.List;

import static utils.PrintUtils.print;

public class StringCompression {

    public static String compressString(String s) {

        StringBuilder compressedSb = new StringBuilder();
        int i = 0, j = 0;
        while (j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                compressedSb.append(s.charAt(i));
                compressedSb.append(j - i);
                i = j;
            }
            j++;
        }

        if (i < s.length()) {
            compressedSb.append(s.charAt(i));
            int count = 0;
            while (i < s.length()) {
                count++;
                i++;
            }
            compressedSb.append(count);
        }

        return compressedSb.toString();
    }

    public static void main(String[] args) {
        print(StringCompression.class.getName());
        print((List<String> inputs) -> compressString(inputs.get(0)), "taabcccccaaaab");
    }
}
