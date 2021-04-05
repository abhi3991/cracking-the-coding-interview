package utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PrintUtils {

    public static <T> void print(T... args) {
        System.out.println(Arrays.stream(args).map(Objects::toString).collect(Collectors.joining(" ")));
    }

    public static <T> void print(Collection<T> collection) {
        System.out.println(collection.stream().map(Objects::toString).collect(Collectors.joining(", ")));
    }

    public static <T, U> void execAndPrint(Function<List<T>, U> toExec, T... args) {
        System.out.println("input: " + Arrays.stream(args)
            .map(Objects::toString)
            .collect(Collectors.joining(", ")));
        System.out.println("output: " + toExec.apply(Arrays.asList(args)));
    }

    public static <T, U> void execAndPrint(Function<T, U> toExec, T arg) {
        System.out.println("input: " + arg);
        System.out.println("output: " + toExec.apply(arg));
    }

    public static <T, U> void execAndPrint(Supplier<T> toExec, U arg) {
        System.out.println("input: " + arg);
        System.out.println("output: " + toExec.get());
    }

    public static <T> void execAndPrint(Supplier<T> toExec, Object ...args) {
        System.out.println("input: " + toString(args));
        System.out.println("output: " + toExec.get());
    }

    public static <T> void execAndPrint(Supplier<T> toExec) {
        System.out.print("output");
        System.out.println(": " + toExec.get());
    }

    public static String toString(Object ...args) {
        return Arrays.stream(args).map(Objects::toString).collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        print("a", 1, 2, 3);
        execAndPrint((List<Integer> inputs) -> inputs.get(0) + inputs.get(1), 1, 2);
    }

}
