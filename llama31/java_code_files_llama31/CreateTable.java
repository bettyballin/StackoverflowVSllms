/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/your_database";
        String string2 = "your_username";
        String string3 = "your_password";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);
             Statement statement = connection.createStatement();){
            String string4 = "CREATE TABLE attribute (name VARCHAR(50) PRIMARY KEY, value_type VARCHAR(10), str_value VARCHAR(100), int_value INT, dec_value DECIMAL)";
            statement.executeUpdate(string4);
            System.out.println("Table created successfully");
        }
        catch (SQLException sQLException) {
            System.out.println("Error creating table: " + sQLException.getMessage());
        }
    }
}
