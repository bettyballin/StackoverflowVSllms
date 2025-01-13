/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FooBarInserter {
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("url", "user", "password");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bar (foo_id) VALUES ((SELECT id FROM foo WHERE name = ?))");
            preparedStatement.setString(1, "Andrey");
            preparedStatement.executeUpdate();
        }
        catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException sQLException) {
                System.out.println(sQLException.getMessage());
            }
        }
    }
}
