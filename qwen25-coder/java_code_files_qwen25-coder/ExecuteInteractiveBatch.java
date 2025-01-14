import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ExecuteInteractiveBatch {

    public static void aFunction(String userInput) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "username", "password");

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
                // Use the passed userInput instead of reading from System.in
                String response = userInput;
                if ("Y".equalsIgnoreCase(response)) {
                    stmt = connection.createStatement();
                    int rowsAffected = stmt.executeUpdate("DELETE from sometable where c=2");
                    System.out.println("" + rowsAffected + " row(s) deleted");
                    stmt.close();
                }
            }
        } catch (SQLException ex) {
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
    }
}