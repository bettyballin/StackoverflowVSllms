import java.util.Arrays;

public class ByteComparator {
    public static void main(String[] args) {
        String expected = "Hello";
        String actual = "World";
        System.out.println(Arrays.toString(expected.getBytes()));
        System.out.println(Arrays.toString(actual.getBytes()));
    }
}