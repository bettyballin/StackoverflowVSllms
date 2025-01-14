import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIRequesterorDataFetchercouldbesuitableclassnamesforthiscode {
    // Inside your Java bean or servlet method:
    private String fetchDataFromAPI(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {
            URL requestUrl = new URL(url);
            urlConnection = (HttpURLConnection) requestUrl.openConnection();
            urlConnection.setRequestMethod("GET");
            
            // Set necessary headers for OAuth, etc.
            urlConnection.setRequestProperty("Authorization", "Bearer YOUR_ACCESS_TOKEN");

            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
            } else {
                // Handle HTTP error codes, example: connectionRefused()
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
    }
}