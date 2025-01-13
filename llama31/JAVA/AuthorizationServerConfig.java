import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Using Spring Security OAuth2
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("your_client_id")
                .secret("your_client_secret")
                .authorizedGrantTypes("authorization_code")
                .scopes("your_scope");
    }
}

// In your web app (RS)
@RestController
@RequestMapping("/protected")
public class ProtectedResourceController {
    @GetMapping
    public String protectedResource(@RequestHeader("Authorization") String accessToken) {
        // Validate the access token with the AS
        // ...
        return "Access granted!";
    }

    public static void main(String[] args) {
    }
}