/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main_734 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            String string = "SELECT * FROM users WHERE name = ? AND age = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(string);){
                preparedStatement.setString(1, "John");
                preparedStatement.setInt(2, 30);
                try (ResultSet resultSet = preparedStatement.executeQuery();){
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("name") + " " + resultSet.getInt("age"));
                    }
                }
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("Error closing connection: " + sQLException.getMessage());
                }
            }
        }
    }
}
