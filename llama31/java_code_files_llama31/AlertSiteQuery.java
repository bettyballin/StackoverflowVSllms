/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlertSiteQuery {
    public static void main(String[] stringArray) {
        String string = "jdbc:sqlserver://your_database_server:1433;databaseName=your_database_name";
        String string2 = "your_username";
        String string3 = "your_password";
        int n = 1;
        try (Connection connection = DriverManager.getConnection(string, string2, string3);){
            String string4 = "SELECT * FROM alerts WHERE site_id IN (SELECT * FROM dbo.udf_get_event_sitelist(?))";
            try (PreparedStatement preparedStatement = connection.prepareStatement(string4);){
                preparedStatement.setInt(1, n);
                try (ResultSet resultSet = preparedStatement.executeQuery();){
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString(1));
                    }
                }
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
