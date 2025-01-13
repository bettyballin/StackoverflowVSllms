/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.SQLException;

public class Main_528 {
    public static void main(String[] stringArray) {
        Connection connection = null;
        try {
            if (connection != null) {
                connection.getMetaData();
            } else {
                System.out.println("Connection object is null.");
            }
        }
        catch (SQLException sQLException) {
            System.out.println("An error occurred while accessing the database metadata: " + sQLException.getMessage());
        }
    }
}
