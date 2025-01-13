import java.lang.String;

public class OracleExceptionHandler {
    public static void main(String[] args) {
        try {
            // database operation
        } catch (OracleException e) {
            if (e.getErrorCode() == 12560 || e.getErrorCode() == 12561 || 
                e.getErrorCode() == 12571 || e.getErrorCode() == 12592 || 
                e.getErrorCode() == 3113) {
                // handle connection error
            } else {
                // handle other errors
            }
        }
    }
}