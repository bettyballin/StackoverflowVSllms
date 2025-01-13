import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// Assuming TokenRepository is a custom interface, you need to define it or import it if it's already defined elsewhere
interface TokenRepository {
    Token findByToken(String token);
}

// Assuming Token is a custom class, you need to define it or import it if it's already defined elsewhere
class Token {
    private String user;
    private String token;
    private SimpleGrantedAuthority[] authorities;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SimpleGrantedAuthority[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(SimpleGrantedAuthority[] authorities) {
        this.authorities = authorities;
    }
}

@Component
public class TokenAuthenticationManager implements AuthenticationManager {

    private final TokenRepository tokenRepository;

    @Autowired
    public TokenAuthenticationManager(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = (String) authentication.getPrincipal();
        Token storedToken = tokenRepository.findByToken(token);
        if (storedToken != null) {
            return new UsernamePasswordAuthenticationToken(storedToken.getUser(), storedToken.getToken(), Arrays.asList(storedToken.getAuthorities()));
        } else {
            throw new BadCredentialsException("Invalid token");
        }
    }

    public static void main(String[] args) {
    }
}