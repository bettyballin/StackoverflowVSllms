/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserPasswordEncoder {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            String string = "testUser";
            String string2 = "testPassword";
            String string3 = "salt";
            int n = 10000;
            int n2 = 256;
            String string4 = PBKDF2.hash(string2, string3, n, n2);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            preparedStatement.setString(1, string);
            preparedStatement.setString(2, string4);
            preparedStatement.executeUpdate();
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
