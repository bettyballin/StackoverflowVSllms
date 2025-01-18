import java.util.Arrays;

public class ChaCha20 {
    private final byte[] key;  // Encryption Key (32 bytes)
    private final byte[] iv;   // Initialization Vector (16 bytes)

    public ChaCha20(byte[] key, byte[] iv) {
        this.key = Arrays.copyOfRange(key, 0, Math.min(32, key.length));
        this.iv = iv;
    }

    // ... Implement encryption functions here ...

    public static void main(String[] args) {
    }
}