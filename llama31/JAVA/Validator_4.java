import java.lang.String;

public class Validator_4 {
    public static boolean isValidEmail(String email) {
        // email validation logic here
        return true; // or false
    }

    public static boolean isValidPassword(String password) {
        // password validation logic here
        return true; // or false
    }
}

public class User {
    private String email;
    private String password;

    public void setEmail(String email) {
        if (!Validator.isValidEmail(email)) {
            // handle invalid email error
        }
        this.email = email;
    }

    public void setPassword(String password) {
        if (!Validator.isValidPassword(password)) {
            // handle invalid password error
        }
        this.password = password;
    }

    public static void main(String[] args) {
    }
}