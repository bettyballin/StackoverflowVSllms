import java.util.Base64;
import java.util.HashMap;

public class ByteArrayPrintBase64Example {
    public static void main(String[] args) {
        HashMap<byte[], byte[]> map = new HashMap<>();
        
        // Example byte arrays
        byte[] key1 = {0, 1, 2, 3};
        byte[] value1 = new byte[32]; // Assume this is initialized elsewhere
        
        byte[] key2 = {4, 5, 6, 7};
        byte[] value2 = new byte[32]; // Assume this is initialized elsewhere

        map.put(key1, value1);
        map.put(key2, value2);

        Base64.Encoder encoder = Base64.getEncoder();
        for (byte[] key : map.keySet()) {
            System.out.println(encoder.encodeToString(key) + ":" + encoder.encodeToString(map.get(key)));
        }
    }
}