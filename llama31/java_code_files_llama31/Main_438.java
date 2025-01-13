/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

public class Main_438 {
    public static void fillYearComboBox(Connection connection, JComboBox jComboBox) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT DISTINCT YEAR(date_field) AS year FROM your_table");){
            while (resultSet.next()) {
                jComboBox.addItem(resultSet.getInt("year"));
            }
        }
        catch (SQLException sQLException) {
            System.out.println("SQL Exception: " + sQLException.getMessage());
        }
    }

    public static void main(String[] stringArray) {
        JComboBox jComboBox = new JComboBox();
        String string = "jdbc:mysql://localhost:3306/your_database";
        String string2 = "your_username";
        String string3 = "your_password";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            Main_438.fillYearComboBox(connection, jComboBox);
        }
        catch (SQLException sQLException) {
            System.out.println("SQL Exception: " + sQLException.getMessage());
        }
    }
}
