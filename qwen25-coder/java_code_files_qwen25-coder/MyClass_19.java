// Note: Ensure that the Oracle JDBC driver (e.g., ojdbc8.jar) is included in the classpath when compiling.
// For example: javac -cp .:ojdbc8.jar MyClass.java

import oracle.sql.TIMESTAMPTZ;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyClass {

    public Timestamp convertTimestamptzToTimestamp(TIMESTAMPTZ timestamptz, Connection connection) throws SQLException {
        return timestamptz.timestampValue(connection);
    }

    public static void main(String[] args) {

        Connection connection = null; // Obtain connection
        Statement statement = null;
        try {
            // Initialize connection and statement
            // connection = DriverManager.getConnection(...);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT your_timestamptz_column FROM your_table");

            MyClass myClass = new MyClass();

            while (rs.next()) {
                TIMESTAMPTZ oracleTstz = (TIMESTAMPTZ) rs.getObject("your_timestamptz_column");
                Timestamp stdTimestamp = myClass.convertTimestamptzToTimestamp(oracleTstz, connection);
                // Use the standard timestamp as needed
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}