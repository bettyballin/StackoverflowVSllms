// Using ScribeJava OAuth 2.0 library
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class Main_402 {
    public static void main(String[] args) {
        // Client credentials
        String clientId = "your_client_id";
        String clientSecret = "your_client_secret";
        String tokenEndpoint = "https://openid.example.com/token";

        // Create OAuth service
        OAuthService service = new ServiceBuilder()
            .provider(org.scribe.builder.api.OpenIDConnectProvider.class)
            .apiKey(clientId)
            .apiSecret(clientSecret)
            .build();

        // Obtain access token
        OAuthRequest request = new OAuthRequest(Verb.POST, tokenEndpoint);
        request.addHeader("Content-Type", "application/x-www-form-urlencoded");
        request.addBodyParameter("grant_type", "client_credentials");
        Token accessToken = service.getRequestToken(); //getResponse is not valid method for OAuthService class
        Response response = service.signAndSend(request, accessToken);
        
        // Use the access token to authenticate with your server
        String authHeader = "Bearer " + accessToken.getToken();
        System.out.println(authHeader); // print authentication header
    }
}