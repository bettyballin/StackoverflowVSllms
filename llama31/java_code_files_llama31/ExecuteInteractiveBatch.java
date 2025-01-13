/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExecuteInteractiveBatch {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void aFunction() {
        Connection connection = null;
        try {
            boolean bl = false;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "username", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count(1) cnt from sometable where c = 2");
            int n = 0;
            if (resultSet.next()) {
                n = resultSet.getInt(1);
            }
            resultSet.close();
            statement.close();
            resultSet = null;
            statement = null;
            if (n == 1) {
                System.out.println("Do you want to continue?");
                Scanner scanner = new Scanner(System.in);
                String string = scanner.nextLine();
                if ("Y".equalsIgnoreCase(string)) {
                    statement = connection.createStatement();
                    int n2 = statement.executeUpdate("DELETE from sometable where c=2");
                    System.out.println(n2 + " row(s) deleted");
                    statement.close();
                }
            }
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            }
            catch (SQLException sQLException) {
                sQLException.printStackTrace();
            }
        }
    }

    public static void main(String[] stringArray) {
        ExecuteInteractiveBatch.aFunction();
    }
}
