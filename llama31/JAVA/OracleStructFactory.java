import java.sql.Connection;
import java.sql.SQLException;

import oracle.sql.Struct;
import oracle.sql.StructDescriptor;

public class OracleStructFactory {
    public static void main(String[] args) {
        // Assuming you have a Connection object named 'connection'
        Connection connection = null; // Initialize with your actual connection

        try {
            StructDescriptor structDescriptor = new StructDescriptor("T_NUMBERS", connection);
            Struct struct = new Struct(structDescriptor, connection, new Object[]{/* your data */});
        } catch (SQLException e) {
            System.err.println("Error creating struct: " + e.getMessage());
        }
    }
}