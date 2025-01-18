import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Use random data
        SecureRandom prng = new SecureRandom();

        // Contains the original sensitive data
        byte[] sensitiveData = new byte[32]; // Replace 32 with the actual size needed

        // Once done with it, overwrite with null data, then securely delete key/map if needed.
        prng.nextBytes(sensitiveData); // Generate a lot of random values.
        Arrays.fill(sensitiveData, (byte) 0); // Fill array with zeroes (erases the memory).

        // Use strong reference for data - nullify this before gc() to avoid finalization and weak references
        HashMap<String, byte[]> sensitiveMap = new HashMap<>();
        sensitiveMap.put("key", sensitiveData);

        // Nullify the map before garbage collection
        sensitiveMap = null;
        System.gc(); // Request garbage collector to run now... it may not honor request but worth a try!
    }
}