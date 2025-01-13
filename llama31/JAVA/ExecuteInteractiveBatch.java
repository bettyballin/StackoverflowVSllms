import java.sql.*;
import java.util.Scanner;

public class ExecuteInteractiveBatch {

    public static void aFunction() {

        Connection connection = null;
        try {
            int rowFetched = 0;

            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish a connection to the database
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "username", "password");

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT count(1) cnt from sometable where c = 2");

            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            rs = null;
            stmt = null;
            if (count == 1) {
                System.out.println("Do you want to continue?");
                Scanner scanner = new Scanner(System.in);
                String response = scanner.nextLine();
                if ("Y".equalsIgnoreCase(response)) {
                    stmt = connection.createStatement();
                    int rowsAffected = stmt.executeUpdate("DELETE from sometable where c=2");
                    System.out.println(rowsAffected + " row(s) deleted");
                    stmt.close();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        aFunction();
    }
}