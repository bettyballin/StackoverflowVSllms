/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleSecureConnection {
    public static void main(String[] stringArray) {
        String string = "jdbc:oracle:thin:@//localhost:1521/ORCL";
        String string2 = "your_username";
        String string3 = "your_password";
        Properties properties = new Properties();
        properties.setProperty("javax.net.ssl.trustStore", "/path/to/truststore.jks");
        properties.setProperty("javax.net.ssl.trustStorePassword", "truststore_password");
        try (Connection connection = DriverManager.getConnection(string, properties);){
            System.out.println("Connected to Oracle DB securely!");
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
