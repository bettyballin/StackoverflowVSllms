import java.io.InputStream;
import java.io.FileInputStream;
import java.security.KeyStore;

public class Main {
    public static void main(String[] args) throws Exception {
        char[] password = "password".toCharArray(); // Store the password in a char array instead of String for security reasons (for easy GC)
        InputStream stream = new FileInputStream("/path_to/yourKeystoreFile.p12");
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(stream, password); // Ensures integrity by checking with the provided password
    }
}