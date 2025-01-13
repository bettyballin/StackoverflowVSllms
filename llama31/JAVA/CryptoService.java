import java.lang.String;

// Define the KeyManager class or import it if it's already defined elsewhere
class KeyManager {
    // Assuming this class has some implementation
}

public class CryptoService {
    private final KeyManager keyManager;

    public CryptoService(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    public String encrypt(String data) {
        // encryption logic using keyManager
        return "Encrypted data"; // Add some implementation or return statement
    }

    public String decrypt(String data) {
        // decryption logic using keyManager
        return "Decrypted data"; // Add some implementation or return statement
    }

    public static void main(String[] args) {
        KeyManager keyManager = new KeyManager();
        CryptoService cryptoService = new CryptoService(keyManager);
        String encryptedData = cryptoService.encrypt("Hello, World!");
        String decryptedData = cryptoService.decrypt(encryptedData);
        System.out.println("Encrypted data: " + encryptedData);
        System.out.println("Decrypted data: " + decryptedData);
    }
}