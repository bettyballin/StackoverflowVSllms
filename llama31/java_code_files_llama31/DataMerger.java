/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataMerger {
    public static void main(String[] stringArray) {
        String string = "MERGE INTO data d USING (SELECT ? as id, ? as key, ? as value FROM dual) s ON (d.id = ? AND d.key = ?) WHEN MATCHED THEN UPDATE SET d.value = ? WHEN NOT MATCHED THEN INSERT (id, key, value) VALUES (?, ?, ?)";
        String string2 = "jdbc:oracle:thin:@//localhost:1521/ORCL";
        String string3 = "username";
        String string4 = "password";
        try (Connection connection = DriverManager.getConnection(string2, string3, string4);){
            PreparedStatement preparedStatement = connection.prepareStatement(string);
            preparedStatement.setString(1, "someid");
            preparedStatement.setString(2, "testKey");
            preparedStatement.setString(3, "someValue");
            preparedStatement.setString(4, "someid");
            preparedStatement.setString(5, "testKey");
            preparedStatement.setString(6, "someValue");
            preparedStatement.setString(7, "someid");
            preparedStatement.setString(8, "testKey");
            preparedStatement.setString(9, "someValue");
            preparedStatement.executeUpdate();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
