import java.lang.String;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextProvider {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

	public static void main(String[] args) {
	}
}