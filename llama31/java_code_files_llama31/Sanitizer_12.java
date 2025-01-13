/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sanitizer_12 {
    public static String sanitize(String string) {
        String string2;
        block8: {
            string = string.trim();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
            try {
                string2 = connection.prepareStatement("SELECT * FROM DUAL").getMetaData().getColumnName(1).replace("'", "\\'").replace("\"", "\\\"");
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
                    throw new RuntimeException("SQL Exception: " + sQLException.getMessage());
                }
            }
            connection.close();
        }
        return string2;
    }

    public static void main(String[] stringArray) {
        System.out.println(Sanitizer_12.sanitize("test input"));
    }
}
