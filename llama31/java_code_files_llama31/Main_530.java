/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.SQLException;

public class Main_530 {
    public static void main(String[] stringArray) throws SQLException {
        Connection connection = null;
        if (connection != null) {
            int n = connection.getNetworkTimeout();
            if (n <= 0) {
                System.out.println("Connection has timed out");
            }
        } else {
            System.out.println("Connection object is null");
        }
    }
}
