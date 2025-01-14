import java.lang.String;
import java.sql.SQLException;

public class UserRepository {
       public void save(User user) throws SQLException {
           // Check for database-level constraints like duplicate entries
           if (userExistsByEmail(user.getEmail())) {
               throw new SQLException("User with this email already exists");
           }
           // Insert into the database...
       }

       private boolean userExistsByEmail(String email) {
           // Query the database to check if a user with the given email exists
           return false; // Simplified for example
       }

       public static void main(String[] args) {
       }
}

class User {
    public String getEmail() {
        return null;
    }
}