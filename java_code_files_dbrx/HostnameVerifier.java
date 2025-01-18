import javax.net.ssl.HttpsURLConnection;

public class HostnameVerifier {
    static {
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> hostname.equals(session.getPeerHost()));
    }

    public static void main(String[] args) {
    }
}