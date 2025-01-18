import java.lang.String;

public class LoginManager {
    boolean isFirstLogin() {
        // Check if 'users' table/file exists, return true only once, and then no longer.
        return true; // Placeholder return statement
    }

    void createAdminAccount(String email, String password){
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        // Save the user as admin in your database/storage...
    }

    public static void main(String[] args) {
    }
}

class User {
    private String email;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}