import java.io.DataInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebServiceExample {
    public void fetchWebServiceData(String urlStr) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try {
            URL url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inputStream = connection.getInputStream();
                // Read data from input stream
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) inputStream.close();
                if (connection != null) connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
    }
}