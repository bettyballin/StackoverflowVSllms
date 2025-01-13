import java.sql.Connection;
import java.sql.SQLException;

import oracle.sql.ArrayDescriptor;

public class OracleArrayLoader {
    Connection connection; // You need to initialize this variable

    public OracleArrayLoader() throws SQLException {
        // Initialize the connection variable
        // Replace the following line with your actual database connection code
        connection = null; // You need to replace this with a valid Connection object
    }

    ArrayDescriptor descriptor;

    public void initDescriptor() throws SQLException {
        descriptor = ArrayDescriptor.createDescriptor("T_NUMBERS", connection);
    }

    public static void main(String[] args) {
        try {
            OracleArrayLoader loader = new OracleArrayLoader();
            loader.initDescriptor();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}