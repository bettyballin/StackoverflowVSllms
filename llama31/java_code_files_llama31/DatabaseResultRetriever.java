/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseResultRetriever {
    public static void main(String[] stringArray) {
        String string = "your_table_name";
        Connection connection = DatabaseResultRetriever.getConnection();
        String string2 = "SELECT t1.business_key, t1.result FROM " + string + " t1 INNER JOIN (     SELECT business_key, MAX(id) as max_id     FROM " + string + "     GROUP BY business_key ) t2 ON t1.business_key = t2.business_key AND t1.id = t2.max_id";
        try (PreparedStatement preparedStatement = connection.prepareStatement(string2);
             ResultSet resultSet = preparedStatement.executeQuery();){
            while (resultSet.next()) {
                int n = resultSet.getInt(1);
                int n2 = resultSet.getInt(2);
            }
        }
        catch (SQLException sQLException) {
            // empty catch block
        }
    }

    private static Connection getConnection() {
        return null;
    }
}
