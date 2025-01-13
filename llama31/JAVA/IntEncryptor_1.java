import java.lang.String;

public class IntEncryptor_1_1 {
    private int secretKey;

    public IntEncryptor_1(int secretKey) {
        this.secretKey = secretKey;
    }

    public int encrypt(int input) {
        int hashed = fnv1a(input);
        return hashed ^ secretKey;
    }

    public int decrypt(int encrypted) {
        int hashed = encrypted ^ secretKey;
        return inverseFNV1a(hashed);
    }

    private int fnv1a(int input) {
        int hash = 2166136261;
        hash ^= input;
        hash *= 16777219;
        return hash;
    }

    private int inverseFNV1a(int hash) {
        // Note: this is not exactly the inverse of FNV-1a,
        // but rather a way to recover the original input
        // from the hashed value
        int input = hash / 16777219;
        input ^= 2166136261;
        return input;
    }

    public static void main(String[] args) {
        IntEncryptor_1 encryptor = new IntEncryptor_1(12345);
        int original = 67890;
        int encrypted = encryptor.encrypt(original);
        int decrypted = encryptor.decrypt(encrypted);
        System.out.println("Original: " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}