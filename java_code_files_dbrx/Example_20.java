// This is a simple example of how one might securely connect using JDBC in Java
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Example {
    public static void main(String[] args) {
        String dbUrl = "jdbc:oracle://localhost"; // your DB URL here
        String username = "<Username>";  // replace with your actual Oracle Server Username
        String password = "<Password>";   // replace this as well. Never hard code Passwords

        try {
            Properties props = new Properties();
            props.setProperty("user", username);
            props.setProperty("password", password);
            props.setProperty("oracle.net.ssl_cipher_suites", "(SSL_RSA_WITH_RC4_128_SHA)");
            // replace with your preferred cipher suite
            // Note: Always ensure to apply encryption, and secure methods of credentials management (never hard-code credentials in real application code)
            DriverManager.getConnection("jdbc:" + dbUrl, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}