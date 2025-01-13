/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionExample {
    public static void main(String[] stringArray) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//your_server_host:your_server_port/your_service_name", "your_username", "your_password");
            connection.close();
        }
        catch (Exception exception) {
            System.err.println("Error connecting to the database: " + exception.getMessage());
        }
    }
}
