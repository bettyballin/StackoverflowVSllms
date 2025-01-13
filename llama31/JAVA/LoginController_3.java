import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController_3_3 {

    @Autowired
    private TokenAuthenticationManager tokenAuthenticationManager;

    @PostMapping
    public String login(@RequestBody LoginRequest loginRequest) {
        String token = loginRequest.getToken();
        Authentication authentication = tokenAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(token, token));
        if (authentication.isAuthenticated()) {
            return "Login successful";
        } else {
            return "Invalid token";
        }
    }

    public static void main(String[] args) {
    }
}

class LoginRequest {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

interface TokenAuthenticationManager {
    Authentication authenticate(UsernamePasswordAuthenticationToken authenticationToken);
}