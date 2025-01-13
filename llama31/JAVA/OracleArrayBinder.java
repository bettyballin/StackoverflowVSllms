import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

public class OracleArrayBinder {
    public static void bindListToPreparedStatement(Connection connection, PreparedStatement statement, String parameterName, List<String> list) throws SQLException {
        // Create an Oracle ARRAY type
        ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("VARCHAR2_ARRAY", connection);
        ARRAY array = new ARRAY(descriptor, connection, list.toArray());

        // Bind the ARRAY to the PreparedStatement
        statement.setArray(parameterName, array);
    }

    public static void main(String[] args) throws SQLException {
        // Example usage
        // Obtain an Oracle Connection
        // You need to replace this with your actual Oracle connection code
        // Connection connection = DriverManager.getConnection("url", "username", "password");

        // For demonstration purposes, assume connection is established
        Connection connection = null;

        List<String> list = new ArrayList<>();
        list.add("value1");
        list.add("value2");
        list.add("value3");

        String query = "SELECT * FROM table WHERE column IN (SELECT * FROM TABLE(:values))";
        // You need to establish a connection first, then prepare the statement
        // PreparedStatement statement = connection.prepareStatement(query);

        // For demonstration purposes, assume statement is prepared
        PreparedStatement statement = null;

        bindListToPreparedStatement(connection, statement, "values", list);

        // Execute the statement
        // statement.executeQuery();
    }
}