import java.lang.String;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

public class WebServiceExample {
    public void callWebService() {
        String url = "http://example.com/webservice";
        HttpConnection connection = null;
        try {
            connection = (HttpConnection) Connector.open(url);
            connection.setRequestMethod(HttpConnection.GET);
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpConnection.HTTP_OK) {
                // Process the response
            }
        } catch (Exception e) {
            // Handle the exception
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    // Handle the exception while closing the connection
                }
            }
        }
    }

    public static void main(String[] args) {
        WebServiceExample example = new WebServiceExample();
        example.callWebService();
    }
}