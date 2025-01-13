/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main_72 {
    public static void main(String[] stringArray) {
        ArrayList<TableField> arrayList = new ArrayList<TableField>();
        arrayList.add(new TableField("table1", "field1"));
        arrayList.add(new TableField("table2", "field2"));
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:example.db");
        }
        catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Error connecting to database: " + exception.getMessage());
            return;
        }
        for (TableField tableField : arrayList) {
            String string = "UPDATE " + tableField.getTableName() + " SET " + tableField.getFieldName() + " = ? WHERE " + tableField.getFieldName() + " = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(string);
                try {
                    preparedStatement.setString(1, "xyz");
                    preparedStatement.setString(2, "123");
                    preparedStatement.executeUpdate();
                }
                finally {
                    if (preparedStatement == null) continue;
                    preparedStatement.close();
                }
            }
            catch (SQLException sQLException) {
                System.out.println("Error updating table: " + sQLException.getMessage());
            }
        }
        try {
            if (connection != null) {
                connection.close();
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error closing connection: " + sQLException.getMessage());
        }
    }
}
