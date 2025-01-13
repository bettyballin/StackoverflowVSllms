/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchemaComparator {
    public static void main(String[] stringArray) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://prod-db:3306/mydb", "username", "password");
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});
            while (resultSet.next()) {
                String string = resultSet.getString("TABLE_NAME");
            }
            System.out.println("Schema differences:");
        }
        catch (SQLException sQLException) {
            System.err.println("Error: " + sQLException.getMessage());
        }
    }
}
