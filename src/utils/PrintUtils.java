package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintUtils {

    public static <T> void print(T ...args) {
        System.out.println(Arrays.stream(args).map(Objects::toString).collect(Collectors.joining(", ")));
    }

    public static <T, U> void print(Function<List<T>, U> toExec, T ...args) {
        System.out.print(Arrays.stream(args).map(Objects::toString).collect(Collectors.joining(", ")));
        System.out.println(": " + toExec.apply(Arrays.asList(args)));
    }

    public static <T, U> void print(Function<T, U> toExec, T arg) {
        System.out.print(arg);
        System.out.println(": " + toExec.apply(arg));
    }

    public static void main(String[] args) {
        print("a", 1, 2, 3);
        print((List<Integer> inputs) -> inputs.get(0) + inputs.get(1), 1, 2);
    }

}
