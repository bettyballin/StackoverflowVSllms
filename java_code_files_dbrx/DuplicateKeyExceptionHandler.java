import java.sql.SQLException;

public class DuplicateKeyExceptionHandler {
    public static void main(String[] args) {
        try {
            // Your SQL insert code here which may throw SQLException due to duplicate keys
        } catch (SQLException e) {
            if (DuplicateKeyChecker.isDuplicate(e)) {
                System.out.println("The error occurred because of a duplicate key violation");
            } else {
                // Handle other kinds of errors here
                throw new RuntimeException("An unexpected SQL error occurred", e);
            }
        }
    }
}