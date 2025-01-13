/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserImageDatabaseTransaction {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Connection connection = null;
        String string = "John Doe";
        String string2 = "john.doe@example.com";
        String string3 = "password123";
        int n = 1;
        byte[] byArray = new byte[]{};
        try {
            connection.setAutoCommit(false);
            String string4 = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(string4);
            preparedStatement.setString(1, string);
            preparedStatement.setString(2, string2);
            preparedStatement.setString(3, string3);
            preparedStatement.executeUpdate();
            String string5 = "INSERT INTO images (user_id, image_data) VALUES (?, ?)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(string5);
            preparedStatement2.setInt(1, n);
            preparedStatement2.setBytes(2, byArray);
            preparedStatement2.executeUpdate();
            connection.commit();
        }
        catch (SQLException sQLException) {
            if (connection != null) {
                try {
                    connection.rollback();
                }
                catch (SQLException sQLException2) {
                    System.out.println("Error rolling back transaction: " + sQLException2.getMessage());
                }
            }
            System.out.println("Error executing transaction: " + sQLException.getMessage());
        }
        finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                }
                catch (SQLException sQLException) {
                    System.out.println("Error resetting auto-commit: " + sQLException.getMessage());
                }
            }
        }
    }
}
