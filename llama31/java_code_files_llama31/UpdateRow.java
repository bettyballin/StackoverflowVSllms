/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRow {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/yourDatabase";
        String string2 = "yourUsername";
        String string3 = "yourPassword";
        String string4 = "yourTableName";
        int n = 1;
        String string5 = "yourColumnName";
        String string6 = "newValue";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE " + string4 + " SET " + string5 + " = ? WHERE id = ?");){
            preparedStatement.setString(1, string6);
            preparedStatement.setInt(2, n);
            preparedStatement.executeUpdate();
            System.out.println("Row updated successfully.");
        }
        catch (SQLException sQLException) {
            System.out.println("Error updating row: " + sQLException.getMessage());
        }
    }
}
