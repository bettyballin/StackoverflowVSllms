import java.sql.*;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.OracleCallableStatement;

public class CallOracleStoredProcedure {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");
            
            // Establish Connection to the database
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "username", "password");

            // Prepare a CallableStatement for calling stored procedure
            String sql = "{call get_employee_data(?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            
            // Register the output parameter as a REF CURSOR
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);

            // Execute the stored procedure
            cstmt.execute();

            // Get the ResultSet from the RefCursor
            ResultSet rs = ((OracleCallableStatement) cstmt).getCursor(1);

            // Process the result set
            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                System.out.println("Employee ID: " + employeeId + ", Name: " + firstName + " " + lastName);
            }

            // Close the result set and statement
            rs.close();
            cstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) conn.close();
        }
    }
}