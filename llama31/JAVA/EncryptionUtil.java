public class EncryptionUtil {
    public static String encrypt(String data) {
        // implementation
        return data; // Added a return statement to avoid compilation error
    }

    public static void main(String[] args) {
        // Added a call to the encrypt method to test it
        String encryptedData = encrypt("Hello, World!");
        System.out.println("Encrypted Data: " + encryptedData);
    }
}