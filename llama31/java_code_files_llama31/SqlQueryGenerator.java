/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class SqlQueryGenerator {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        List<String> list = Arrays.asList("A", "B", "C");
        Connection connection = null;
        try {
            connection = null;
            Object object = "SELECT my_column FROM my_table WHERE search_column IN (";
            for (int i = 0; i < list.size(); ++i) {
                object = (String)object + "?";
                if (i >= list.size() - 1) continue;
                object = (String)object + ",";
            }
            object = (String)object + ")";
            PreparedStatement preparedStatement = connection.prepareStatement((String)object);
            for (int i = 0; i < list.size(); ++i) {
                preparedStatement.setString(i + 1, list.get(i));
            }
            preparedStatement.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Error generating or executing SQL query: " + sQLException.getMessage());
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("Error closing database connection: " + sQLException.getMessage());
                }
            }
        }
    }
}
