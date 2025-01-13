/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    public static void main(String[] stringArray) {
        DatabaseHelper databaseHelper = new DatabaseHelper();
        databaseHelper.getLastID();
    }

    public int getLastID() {
        int n = -1;
        try (Connection connection = DriverManager.getConnection("your_database_url", "your_username", "your_password");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT @@IDENTITY AS ins_id");){
            if (resultSet.next()) {
                n = resultSet.getInt("ins_id");
            }
        }
        catch (SQLException sQLException) {
            // empty catch block
        }
        return n;
    }
}
