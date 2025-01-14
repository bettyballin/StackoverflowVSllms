import java.lang.String;
import java.util.Properties;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.InputStream;

public class ThirdPartyAccessService {
    private static final String CONFIG_FILE_PATH = "config.properties";

    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get(CONFIG_FILE_PATH))) {
            prop.load(input);
        }

        String encryptedUsername = prop.getProperty("username");
        String encryptedPassword = prop.getProperty("password");

        String username = SecureUtil.decrypt(encryptedUsername);
        String password = SecureUtil.decrypt(encryptedPassword);

        // Use username and password to access third-party application
        System.out.println("Accessing third-party app with username: " + username);
    }
}

class SecureUtil {
    public static String decrypt(String encrypted) {
        // Decrypt the string and return the result
        // Placeholder for decryption logic
        return encrypted;
    }
}