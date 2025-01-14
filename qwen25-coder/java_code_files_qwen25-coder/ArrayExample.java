import java.lang.String;
import java.lang.Integer;
public class ArrayExample {
    public static void main(String[] args) {
        int[] primitiveArray = new int[10];
        Integer[] wrapperArray = new Integer[10];

        System.out.println("Primitive array size: " + (primitiveArray.length * 4)); // 4 bytes per int
        // Note: Calculating exact memory usage of Integer[] is more complex and depends on JVM implementation.
    }
}