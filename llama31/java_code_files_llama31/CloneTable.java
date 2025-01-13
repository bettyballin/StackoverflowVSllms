/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CloneTable {
    public static void main(String[] stringArray) {
        String string = "FRED";
        String string2 = "FRED_CLONE";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");
            Statement statement = connection.createStatement();
            String string3 = "CREATE TABLE " + string2 + " AS SELECT * FROM " + string + " WHERE 1=0";
            statement.execute(string3);
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println("An error occurred: " + exception.getMessage());
        }
    }
}
