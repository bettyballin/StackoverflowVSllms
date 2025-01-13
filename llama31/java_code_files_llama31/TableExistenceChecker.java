/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableExistenceChecker {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql://localhost:3306/mydatabase";
        String string2 = "myusername";
        String string3 = "mypassword";
        String string4 = "mytable";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getTables(null, null, string4, new String[]{"TABLE"});
            if (resultSet.next()) {
                System.out.println("Table " + string4 + " exists.");
            } else {
                System.out.println("Table " + string4 + " does not exist.");
            }
        }
        catch (SQLException sQLException) {
            System.err.println("Error checking table existence: " + sQLException.getMessage());
        }
    }
}
