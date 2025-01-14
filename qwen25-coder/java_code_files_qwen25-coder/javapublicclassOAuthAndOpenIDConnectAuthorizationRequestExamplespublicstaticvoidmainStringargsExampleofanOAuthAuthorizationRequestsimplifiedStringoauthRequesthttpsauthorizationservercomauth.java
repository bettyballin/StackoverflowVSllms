import java.lang.String;

public class OAuthAndOpenIDConnectAuthorizationRequestExamples {
    // Example of an OAuth Authorization Request (simplified)
    String oauthRequest = "https://authorization-server.com/auth?"
            + "response_type=code&"
            + "client_id=your-client-id&"
            + "redirect_uri=https://yourwebsite.com/callback&"
            + "scope=read&"
            + "state=some-state";

    // Example of an OpenID Connect Authorization Request (simplified)
    String openIdRequest = "https://authorization-server.com/auth?"
            + "response_type=code&"
            + "client_id=your-client-id&"
            + "redirect_uri=https://yourwebsite.com/callback&"
            + "scope=openid profile email&" // OpenID Connect scopes
            + "state=some-state";

    public static void main(String[] args) {
    }
}