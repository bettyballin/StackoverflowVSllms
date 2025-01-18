import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // Updated driver class name

            // Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/yourdb", "user", "password");

            // Prepare the SQL statement
            String prepared_sql = "insert into models(model) values (?)";
            PreparedStatement pstmt = con.prepareStatement(prepared_sql); // Prepare the insert query

            // Assuming you already have byte array of your trained ML Model
            byte[] modelBytes = getModelBytes();

            pstmt.setBytes(1, modelBytes);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected < 0) {
                // Throw exception or log error if needed
            }

            // Close resources
            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Dummy method to get model bytes
    public static byte[] getModelBytes() {
        // For demonstration purposes, we'll create a dummy byte array
        byte[] modelBytes = {1, 2, 3, 4, 5};
        return modelBytes;
    }
}