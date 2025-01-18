import java.lang.String;
import java.sql.SQLException;

public class SQLExceptionHandle {
    public static void main(String[] args) {
        try {
            // Your database logic here...
        } catch (SQLException e) {
            int errorCode = e.getErrorCode();  // get error code, i.e., ORA-XXXXX
            String message = e.getMessage();   // get the error description/message

            // Add your custom handling for different error codes and messages here...
        } catch (Exception ex) {
            // Handle other exceptions
        }
    }
}