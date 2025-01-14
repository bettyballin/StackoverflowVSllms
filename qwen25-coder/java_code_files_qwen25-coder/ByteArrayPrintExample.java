import java.util.HashMap;
import java.util.Arrays;

public class ByteArrayPrintExample {
    public static void main(String[] args) {
        HashMap<byte[], byte[]> map = new HashMap<>();
        
        // Example byte arrays
        byte[] key1 = {0, 1, 2, 3};
        byte[] value1 = new byte[32]; // Assume this is initialized elsewhere
        
        byte[] key2 = {4, 5, 6, 7};
        byte[] value2 = new byte[32]; // Assume this is initialized elsewhere

        map.put(key1, value1);
        map.put(key2, value2);

        for (byte[] key : map.keySet()) {
            System.out.println(Arrays.toString(key) + ":" + Arrays.toString(map.get(key)));
        }
    }
}