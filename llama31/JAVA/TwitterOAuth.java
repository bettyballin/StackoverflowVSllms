import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import java.net.HttpURLConnection;
import java.net.URL;

public class TwitterOAuth {
    public static void main(String[] args) throws Exception {
        // Set up OAuth consumer
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer("your_consumer_key", "your_consumer_secret");

        // Request authorization
        String authorizationUrl = consumer.getAuthorizationUrl("https://api.twitter.com/oauth/request_token");
        System.out.println("Redirect user to authorization URL: " + authorizationUrl);

        // Handle callback from authorization server
        String verifier = "your_verifier"; // Replace with the actual verifier
        String accessToken = consumer.getAccessToken(verifier);

        // Use access token to access user's account
        String apiUrl = "https://api.twitter.com/1.1/statuses/update.json";
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Authorization", "Bearer " + accessToken);
        connection.setRequestMethod("POST");
        // Post update to Twitter
        System.out.println("Posted update to Twitter");
    }
}