import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class MyClass {
    public static void main(String[] args) throws Exception {
        HttpsURLConnection urlConnection = (HttpsURLConnection) new URL("https://example.com/login").openConnection();
        urlConnection.setRequestMethod("POST");
        // Set other necessary properties
    }
}