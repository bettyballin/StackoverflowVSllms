import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

public class OAuthClientConfig {
    // Set up OAuth 2.0 client details
    BaseClientDetails clientDetails = new BaseClientDetails();
    {
        clientDetails.setClientId("your_client_id");
        clientDetails.setClientSecret("your_client_secret");
    }

    // Validate client credentials
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(clientDetails.getClientId())
                .secret(clientDetails.getClientSecret())
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("read", "write");
    }

    public static void main(String[] args) throws Exception {
        OAuthClientConfig config = new OAuthClientConfig();
        // Create an instance of ClientDetailsServiceConfigurer
        ClientDetailsServiceConfigurer clients = new ClientDetailsServiceConfigurer(null);
        config.configure(clients);
    }
}