/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main_672 {
    public static void main(String[] stringArray) {
        try {
            String string = "your_database_url";
            String string2 = "your_username";
            String string3 = "your_password";
            Connection connection = DriverManager.getConnection(string, string2, string3);
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});
            while (resultSet.next()) {
                String string4 = resultSet.getString("TABLE_NAME");
                System.out.println("Table: " + string4);
                ResultSet resultSet2 = databaseMetaData.getColumns(null, null, string4, null);
                while (resultSet2.next()) {
                    String string5 = resultSet2.getString("COLUMN_NAME");
                    System.out.println("  Column: " + string5);
                }
            }
            connection.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
