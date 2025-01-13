import java.lang.String;
import com.opensymphony.xwork2.ActionSupport;

// Example of input validation using Struts Validator
public class MyAction_6_6 extends ActionSupport {
    private String username;

    @Override
    public void validate() {
        if (username == null || username.isEmpty()) {
            addActionError("Username is required");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static void main(String[] args) {
    }
}