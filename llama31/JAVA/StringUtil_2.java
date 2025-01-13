import java.util.Arrays;

public class StringUtil_2_2 {
    public static void main(String[] args) {
        String[] collectionOfStrings = {"Hello", "World", "This", "Is", "A", "Test"};
        String result = String.join(",", collectionOfStrings);
        System.out.println(result);
    }
}