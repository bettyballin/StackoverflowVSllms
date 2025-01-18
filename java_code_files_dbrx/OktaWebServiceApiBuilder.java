import java.lang.String;
import okhttp3.OkHttpClient;

public class OktaWebServiceApiBuilder {
    private static final String CLIENT_ID = "your_client_id";
    private static final String CLIENT_SECRET = "your_client_secret";

    OkHttpClient client = new OkHttpClient();
    AuthenticationTokenManager tokenManager = AuthenticationTokenManager.builder()
        .client(client)
        .tokenEndpoint("https://example.oktapreview.com/oauth2/aus5kasqxTiOWJIaS0x7/v1/token")
        .clientCredentials(new ClientCredentials(CLIENT_ID, CLIENT_SECRET))
        .build();
    WebServiceApi api = new WebServiceApi.Builder()
        .baseUrl("https://example.com/api/")
        // replace with your service endpoint and scope
        .authenticationTokenManager(tokenManager)
        .addScopes(AuthenticationScope.OFFLINE_ACCESS, "myscopename")
        .build();

    public static void main(String[] args) {
    }
}