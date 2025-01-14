import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchHTML {
    public static void main(String[] args) {
        StringBuilder htmlContent = new StringBuilder();
        try {
            URL url = new URL("http://example.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                htmlContent.append(inputLine);
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(htmlContent.toString());
    }
}