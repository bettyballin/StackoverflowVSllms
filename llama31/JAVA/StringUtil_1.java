import java.util.Arrays;

public class StringUtil_1_1 {
    public static void main(String[] args) {
        String[] array = {"Hello", "world", "abc", "ABC", "xyz"};
        Arrays.sort(array, String.CASE_INSENSITIVE_ORDER);
        // Print the sorted array
        for (String s : array) {
            System.out.println(s);
        }
    }
}