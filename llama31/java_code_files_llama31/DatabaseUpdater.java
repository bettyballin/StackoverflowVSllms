/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUpdater {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/your_database";
        String string2 = "your_username";
        String string3 = "your_password";
        String[] stringArray2 = new String[]{"column1", "column2", "column3"};
        int[] nArray = new int[]{1, 2, 3};
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            DatabaseUpdater databaseUpdater = new DatabaseUpdater();
            databaseUpdater.updateDatabase(connection, stringArray2, nArray);
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }

    public void updateDatabase(Connection connection, String[] stringArray, int[] nArray) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO your_table (unique_column, counter) VALUES (?, ?) ON DUPLICATE KEY UPDATE counter = counter + VALUES(counter)");){
            for (int i = 0; i < stringArray.length; ++i) {
                preparedStatement.setString(1, stringArray[i]);
                preparedStatement.setInt(2, nArray[i]);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
