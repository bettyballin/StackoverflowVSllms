import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class Main_211 {
    public static void main(String[] args) {
        // Assuming you have a Connection object named 'conn'
        Connection conn = null; // Initialize conn here

        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "username", "password");

            CallableStatement cs = conn.prepareCall("BEGIN my_procedure(?); END;");
            cs.registerOutParameter(1, OracleTypes.CURSOR);

            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                // Process the result set
                System.out.println(rs.getString(1));
            }

            rs.close();
            cs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading Oracle JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}