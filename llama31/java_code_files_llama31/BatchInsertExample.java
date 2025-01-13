/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchInsertExample {
    public static void main(String[] stringArray) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:your_database.db");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mytable (column1, column2) VALUES (?, ?)");
        int n = 32768;
        int n2 = 0;
        for (int i = 0; i < 100000; ++i) {
            preparedStatement.setString(1, "value1-" + i);
            preparedStatement.setString(2, "value2-" + i);
            preparedStatement.addBatch();
            if (++n2 < n) continue;
            preparedStatement.executeBatch();
            n2 = 0;
        }
        if (n2 > 0) {
            preparedStatement.executeBatch();
        }
        preparedStatement.close();
        connection.close();
    }
}
