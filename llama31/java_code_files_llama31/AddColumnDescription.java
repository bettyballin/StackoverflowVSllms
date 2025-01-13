/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddColumnDescription {
    public static void main(String[] stringArray) {
        String string = "jdbc:sqlserver://your_server:1433;databaseName=your_database";
        String string2 = "your_username";
        String string3 = "your_password";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(string, string2, string3);
        }
        catch (SQLException sQLException) {
            System.out.println("Error connecting to database: " + sQLException.getMessage());
            return;
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
        }
        catch (SQLException sQLException) {
            System.out.println("Error creating statement: " + sQLException.getMessage());
            return;
        }
        String string4 = "your_table_name";
        String string5 = "your_column_name";
        String string6 = "This is a description of the column";
        String string7 = "EXEC sp_addextendedproperty @name=N'MS_Description', @value=N'" + string6 + "', @level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'" + string4 + "', @level2type=N'COLUMN', @level2name=N'" + string5 + "'";
        try {
            statement.execute(string7);
        }
        catch (SQLException sQLException) {
            System.out.println("Error adding column description: " + sQLException.getMessage());
        }
        try {
            statement.close();
            connection.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Error closing resources: " + sQLException.getMessage());
        }
    }
}
