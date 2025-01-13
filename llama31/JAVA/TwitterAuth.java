import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterAuth {
    public static void main(String[] args) throws Exception {
        // Set up your Twitter API credentials
        String consumerKey = "your_consumer_key";
        String consumerSecret = "your_consumer_secret";

        // Create a Twitter instance
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.setOAuthConsumer(consumerKey, consumerSecret);

        // Get a request token
        RequestToken requestToken = twitter.getOAuthRequestToken();

        // Redirect the user to the authorization URL
        String authorizationURL = requestToken.getAuthorizationURL();
        System.out.println("Open the following URL and grant access to your account:");
        System.out.println(authorizationURL);

        // Get the access token
        AccessToken accessToken = twitter.getOAuthAccessToken(requestToken);

        // Use the access token to authenticate API requests
        twitter.setOAuthAccessToken(accessToken);
    }
}