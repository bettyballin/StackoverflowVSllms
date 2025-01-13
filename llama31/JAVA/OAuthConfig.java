import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerConfigurerAdapter;

@Configuration
@EnableAuthorizationServer
@EnableResourceServer
public class OAuthConfig extends AuthorizationServerConfigurerAdapter {
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("your_client_id")
                .secret("your_client_secret")
                .authorizedGrantTypes("client_credentials");
    }
    
    public static void main(String[] args) {
    }
}