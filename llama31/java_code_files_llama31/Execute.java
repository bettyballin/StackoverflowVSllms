/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class Execute {
    private String query1 = "SELECT plantID, edrman, plant, vaxnode FROM ";

    public Execute(String string) {
        try {
            String[] stringArray = new String[]{"table1", "table2"};
            if (!Arrays.asList(stringArray).contains(string)) {
                throw new Exception("Invalid table name");
            }
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection connection = DriverManager.getConnection("jdbc:odbc:DB_MERC");
            PreparedStatement preparedStatement = connection.prepareStatement(this.query1 + "[" + string + "]");
            ResultSet resultSet = preparedStatement.executeQuery();
        }
        catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    public static void main(String[] stringArray) {
        new Execute("table1");
    }
}
