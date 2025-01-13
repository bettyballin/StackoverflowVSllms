import java.util.Arrays;
import java.util.Comparator;

public class Main_597 {
    public static int findMaxLen(String[] array) {
        return Arrays.stream(array)
                .max(Comparator.comparingInt(String::length))
                .map(String::length)
                .orElse(0);
    }

    public static void main(String[] args) {
        String[] array = {"apple", "banana", "orange"};
        System.out.println(findMaxLen(array));
    }
}