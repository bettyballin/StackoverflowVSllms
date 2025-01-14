import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {
    private String fullName;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
                             String fullName) {
        super(username, password, authorities);
        this.fullName = fullName;
    }

    // Getter and other necessary methods
    public String getFullName() {
        return fullName;
    }

	public static void main(String[] args) {
	}
}