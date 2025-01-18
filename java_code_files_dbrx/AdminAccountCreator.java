import java.lang.String;
public class AdminAccountCreator {
    void createAdminAccountThruInstallUI(String email, String password){
        User newUser = new User();
        newUser.setRole("admin"); // flag this user as the administrator!
        newUser.setEmail(email);
        newUser.setPassword(password);
       // Save the user in your database/storage...
    }
    public static void main(String[] args) {
    }
    class User {
        public void setRole(String role) {
        }
        public void setEmail(String email) {
        }
        public void setPassword(String password) {
        }
    }
}