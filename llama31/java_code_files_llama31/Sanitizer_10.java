/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sanitizer_10 {
    public static String sanitize(String string) {
        String string2;
        block8: {
            string = string.trim();
            Connection connection = DriverManager.getConnection("your_database_url", "your_username", "your_password");
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT ?");
                preparedStatement.setString(1, string);
                string2 = preparedStatement.toString();
                if (connection == null) break block8;
            }
            catch (Throwable throwable) {
                try {
                    if (connection != null) {
                        try {
                            connection.close();
                        }
                        catch (Throwable throwable2) {
                            throwable.addSuppressed(throwable2);
                        }
                    }
                    throw throwable;
                }
                catch (SQLException sQLException) {
                    throw new RuntimeException(sQLException);
                }
            }
            connection.close();
        }
        return string2;
    }

    public static void main(String[] stringArray) {
        System.out.println(Sanitizer_10.sanitize("   Hello, World!   "));
    }
}
