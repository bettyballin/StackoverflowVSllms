/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {
    public static void main(String[] stringArray) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:derby:myDB;create=true");
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE SomeTable(id INTEGER IDENTITY, text LONGVARCHAR)");
            statement.close();
            connection.close();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
