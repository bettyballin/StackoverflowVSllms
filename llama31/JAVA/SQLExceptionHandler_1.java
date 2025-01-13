import java.sql.SQLException;

public class SQLExceptionHandler_1_1 {
    public static void main(String[] args) {
        try {
            // insert statement
        } catch (SQLException e) {
            if (e.getSQLState().startsWith("23")) {
                // duplicate key error
            } else {
                // handle other SQL exceptions
            }
        }
    }
}