import java.lang.String;
import java.io.Serializable;

class ActionForm {
}

public class LoginForm extends ActionForm implements Serializable {
    private String username;
    private String password;

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

	public static void main(String[] args) {
	}
}