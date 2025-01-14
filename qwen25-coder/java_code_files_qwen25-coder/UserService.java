import java.lang.String;

public class UserService {
       public void registerUser(User user) {
           if (!isValidEmail(user.getEmail())) {
               throw new IllegalArgumentException("Invalid email format");
           }
           // Additional business rules...
       }

       private boolean isValidEmail(String email) {
           return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}");
       }

       public static void main(String[] args) {
       }
}