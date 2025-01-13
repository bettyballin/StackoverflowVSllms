import java.lang.String;

public class DESKeyGenerator {
    // Insecure way to create a DES key
    String password = "password";
    byte[] key = password.getBytes();

    public static void main(String[] args) {
        DESKeyGenerator generator = new DESKeyGenerator();
        System.out.println("Generated Key: " + java.util.Arrays.toString(generator.key));
    }
}