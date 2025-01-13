/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleMetadataTest {
    public static void main(String[] stringArray) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'ARTIST'");
        while (resultSet.next()) {
            System.out.println("Constraint name: " + resultSet.getString("CONSTRAINT_NAME"));
            System.out.println("Constraint type: " + resultSet.getString("CONSTRAINT_TYPE"));
            System.out.println("Table name: " + resultSet.getString("TABLE_NAME"));
            System.out.println("Column names: ");
            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM ALL_CONS_COLUMNS WHERE CONSTRAINT_NAME = '" + resultSet.getString("CONSTRAINT_NAME") + "'");
            while (resultSet2.next()) {
                System.out.println("  " + resultSet2.getString("COLUMN_NAME"));
            }
            resultSet2.close();
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
