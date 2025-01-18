import java.lang.String;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Base64;

public class HttpRequester {
    static String username;
    static String password;

    public static String postRequestWithAuthorization(URL url) throws Exception {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        // add request header
        con.setRequestMethod("POST");
        Base64.Encoder encoder = Base64.getEncoder();
        // encode username and password as base64 encoded string and set in Authorization header
        String authStr = username + ":" + password;
        String encoding = encoder.encodeToString(authStr.getBytes("UTF-8"));
        con.setRequestProperty("Authorization", "Basic " + encoding);
        return null;
    }

    public static void main(String[] args) {
    }
}