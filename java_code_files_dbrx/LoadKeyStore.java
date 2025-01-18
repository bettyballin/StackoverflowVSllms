import java.nio.file.*;
import java.io.*;
import java.util.Arrays;

public class LoadKeyStore {

    public static void main(String[] args) throws IOException {
        // Load KeyStore from File
        String password = "keystore_password";
        char[] passwordCharArray = Arrays.copyOf(password.toCharArray(), 256);
        Path keystoreFile = FileSystems.getDefault().getPath(".", "<path-to>", "keystore");
        InputStream isKeystore = Files.newInputStream(keystoreFile, StandardOpenOption.CREATE);
    }
}