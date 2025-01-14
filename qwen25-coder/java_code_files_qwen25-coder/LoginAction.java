import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends ActionSupport {

    private String username;
    private String password;

    // Getters and setters for username and password

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    } 

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        if (authenticateUser(username, password)) {  // Implement your authentication logic here
            getSession().put("user", new User(username));  // Store user info in session
            return SUCCESS;  // Redirect to the appropriate page after login
        } else {
            addActionError("Invalid username or password.");
            return INPUT;  // Stay on the login form with error messages
        }
    }

    private boolean authenticateUser(String username, String password) {
        // Implement your user authentication logic here
        return true; // Simplified for example
    }

    @SuppressWarnings("unchecked")
    protected Map<String, Object> getSession() {
        return ActionContext.getContext().getSession();
    }

    public static void main(String[] args) {
        // Code to test the LoginAction
        LoginAction action = new LoginAction();
        action.setUsername("testuser");
        action.setPassword("testpass");
        try {
            String result = action.execute();
            System.out.println("Result: " + result);
            if (result.equals(SUCCESS)) {
                System.out.println("Login successful");
            } else if (result.equals(INPUT)) {
                System.out.println("Login failed");
                System.out.println("Errors: " + action.getActionErrors());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}