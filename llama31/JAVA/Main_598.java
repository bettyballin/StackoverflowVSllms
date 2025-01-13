import java.util.Arrays;

public class Main_598 {
    public static int findMaxLen(String[] array) {
        return Arrays.stream(array)
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public static void main(String[] args) {
        String[] array = {"apple", "banana", "cherry"};
        System.out.println(findMaxLen(array));
    }
}