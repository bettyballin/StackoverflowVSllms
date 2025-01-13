import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;

public class Main_657 {
    public static void main(String[] args) {
        String dbPassword = "your_database_password"; // replace with your database password

        // Create a new instance of ConfigurablePasswordEncryptor
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();

        // Encrypt password
        String encryptedPassword = passwordEncryptor.encrypt(dbPassword);
        System.out.println("Encrypted password: " + encryptedPassword);

        // Decrypt password
        String decryptedPassword = passwordEncryptor.decrypt(encryptedPassword);
        System.out.println("Decrypted password: " + decryptedPassword);
    }
}