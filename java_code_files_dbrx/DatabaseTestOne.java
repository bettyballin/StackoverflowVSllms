import java.lang.String;
import java.sql.*;

public class DatabaseTestOne {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // replace these values with your DB details
        String username = "HR";
        String password = "samplepass";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT EMPLOYEE_ID, LAST_NAME FROM EMPLOYEES WHERE LAST_NAME='King'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql); // execute for a query to return Resultset
            while(resultSet.next()){
                String lastName = resultSet.getString("LAST_NAME");
                System.out.println(lastName);
            }
        } catch (SQLException ex) {
             System.err.println(ex);
        }
    }
}