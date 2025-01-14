import java.lang.String;
public class UserDTO {
    private String username;
    private String email;

    // Constructors, getters, and setters

    public UserDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public static void main(String[] args) {
	}
}