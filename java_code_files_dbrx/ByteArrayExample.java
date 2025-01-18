import java.util.Arrays;

public class ByteArrayExample {
    public static void main(String[] args) {
        byte[] byteArray = {0x41, 0x42}; // some data
        System.out.println("My array is: " + Arrays.toString(byteArray));
        // Output example: My array is: [65, 66...] depending on the actual values in byte[] and their decimal representation
    }
}