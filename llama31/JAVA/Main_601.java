import java.util.Arrays;
import java.util.Objects;

public class Main_601_601 {
    public static boolean anyNull(Object... args) {
        return Arrays.stream(args).anyMatch(Objects::isNull);
    }

    public static void main(String[] args) {
        Object a = "Hello";
        Object b = null;
        Object c = "World";
        Object d = 123;

        if (anyNull(a, b, c, d)) {
            System.out.println("At least one is null");
        }
    }
}