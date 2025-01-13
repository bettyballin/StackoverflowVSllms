/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseResultCounter {
    public static void main(String[] stringArray) {
        ResultSet resultSet = null;
        try {
            if (resultSet != null) {
                resultSet.last();
                int n = resultSet.getRow();
                System.out.println("Row count: " + n);
            } else {
                System.out.println("ResultSet is null");
            }
        }
        catch (SQLException sQLException) {
            System.err.println("Error processing ResultSet: " + sQLException.getMessage());
        }
    }
}
