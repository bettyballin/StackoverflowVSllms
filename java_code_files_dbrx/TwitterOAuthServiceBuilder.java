import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuthService;
import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.model.Token;

public class TwitterOAuthServiceBuilder {

    public static void main(String[] args) throws Exception {

        OAuthService service = new ServiceBuilder()
            .provider(TwitterApi.class) // replace with your preferred provider
            .apiKey("your-api-key")
            .apiSecret("your-api-secret")
            .callback("your-callback-url")
            .build();

        // Obtain the Request Token
        Token requestToken = service.getRequestToken();

        // Redirect to the Authorization URL
        String authorizationUrl = service.getAuthorizationUrl(requestToken);
        System.out.println("Please go to " + authorizationUrl);
    }
}