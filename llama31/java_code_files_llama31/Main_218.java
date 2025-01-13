/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_218 {
    public static void main(String[] stringArray) {
        try (Connection connection = Main_218.getConnection();){
            connection.setAutoCommit(false);
            Main_218.updateTableX(connection, "value1", "value2");
            Main_218.updateTableY(connection, "value3", "value4");
            connection.commit();
        }
        catch (SQLException sQLException) {
            System.out.println("An error occurred: " + sQLException.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
    }

    public static void updateTableX(Connection connection, String string, String string2) throws SQLException {
        try (Statement statement = connection.createStatement();){
            statement.executeUpdate("UPDATE table_x SET column1 = '" + string + "', column2 = '" + string2 + "'");
        }
    }

    public static void updateTableY(Connection connection, String string, String string2) throws SQLException {
        try (Statement statement = connection.createStatement();){
            statement.executeUpdate("UPDATE table_y SET column1 = '" + string + "', column2 = '" + string2 + "'");
        }
    }
}
