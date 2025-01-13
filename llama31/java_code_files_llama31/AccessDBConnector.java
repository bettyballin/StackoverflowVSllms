/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessDBConnector {
    public static void main(String[] stringArray) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Error loading driver: " + classNotFoundException.getMessage());
            return;
        }
        String string = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ=\\\\path\\to\\your\\database.mdb";
        try (Connection connection = DriverManager.getConnection(string);){
            System.out.println("Connected to the database!");
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");){
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error connecting to the database: " + sQLException.getMessage());
        }
    }
}
