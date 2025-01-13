/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NexusDBConnector {
    public static void main(String[] stringArray) {
        String string = "jdbc:odbc:nexusdb";
        String string2 = "your_username";
        String string3 = "your_password";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");){
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        }
        catch (SQLException sQLException) {
            System.err.println("Error connecting to NexusDB: " + sQLException.getMessage());
        }
    }
}
