package arraysandstrings;

import java.util.List;
import java.util.function.Function;

import static utils.PrintUtils.execAndPrint;
import static utils.PrintUtils.print;

public class URLify {

    public static String toUrlString(String input, int actualLen) {
        int i = actualLen - 1;
        int j = input.length() - 1;

        char[] inputArr = input.toCharArray();

        while (i >= 0) {
            if (inputArr[i] != ' ') {
                inputArr[j--] = inputArr[i];
            } else {
                inputArr[j--] = '0';
                inputArr[j--] = '2';
                inputArr[j--] = '%';
            }
            i--;
        }
        return new String(inputArr);
    }

    public static void main(String[] args) {
        Function<List<String>, String> toExec = (inputs) -> toUrlString(inputs.get(0), Integer.parseInt(inputs.get(1)));
        print(URLify.class.getName());

        execAndPrint(toExec, "Mr John Smith    ", "13");
        execAndPrint(toExec, " Mr John Smith !!        ", "17");
    }

}
