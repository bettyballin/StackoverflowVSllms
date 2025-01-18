import java.sql.*;

public class PreparedStatementExample_1 {

    String name = "User Input"; // Replace this with actual user input

    {
        try {
            Connection con = DriverManager.getConnection("jdbcURL", "username", "password"); //Replace these with the respective values
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM TableName WHERE columnName = ?");
            stmt.setString(1, name); // Bind variable for user input at index 1
            ResultSet rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PreparedStatementExample_1();
    }
}