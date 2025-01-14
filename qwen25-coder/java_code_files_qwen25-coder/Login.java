package myvalidators;
import java.lang.String;

public class Login {
    private String userName;
    private String userPassword;

    public void setUserName(String userName) {
        this.userName = userName; // Changed underscore variable to camelCase
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword; // Changed underscore variable to camelCase
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public String loginUser() { // Renamed method to start with lowercase for convention but does not affect functionality 
        return "success";
        // Implement actual login logic here
    }

	public static void main(String[] args) {
	}
}