/*
 * Decompiled with CFR 0.152.
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SequenceFetcher {
    public static void main(String[] stringArray) {
        try (Connection connection = DriverManager.getConnection("your_database_url", "your_username", "your_password");){
            CallableStatement callableStatement = connection.prepareCall("BEGIN fetch_ids(?, ?); END;");
            callableStatement.setString(1, "my_sequence");
            callableStatement.setInt(2, 100);
            callableStatement.execute();
        }
        catch (SQLException sQLException) {
            System.err.println("Error: " + sQLException.getMessage());
        }
    }
}
