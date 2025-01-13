/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_25 {
    public static String sanitize(String string) {
        String string2;
        block8: {
            string = string.trim();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT ?");
                preparedStatement.setString(1, string);
                string2 = preparedStatement.toString().replace("SELECT ", "");
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
        System.out.println(Main_25.sanitize("Hello, World!"));
    }
}
