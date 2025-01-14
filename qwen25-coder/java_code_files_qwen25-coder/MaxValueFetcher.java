import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MaxValueFetcher {

    public static void main(String[] args) {
        String urlString = "YOUR_URL_HERE"; // Replace with your URL
        String columnToCheck = "YOUR_COLUMN_NAME"; // The column you are interested in

        try {
            List<Double> values = fetchValuesFromUrl(urlString, columnToCheck);
            double maxValue = findMaxValue(values);
            System.out.println("The highest value is: " + maxValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Double> fetchValuesFromUrl(String urlString, String columnToCheck) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();

        // Assuming the response is a JSON array, you would parse it accordingly
        return parseJsonToValues(content.toString(), columnToCheck); // Implement this parsing method based on your actual data format
    }

    private static double findMaxValue(List<Double> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("List of values cannot be empty or null");
        }
        return values.stream().max(Double::compare).orElseThrow(() -> new RuntimeException("Unable to determine max value"));
    }

    // This method needs to be implemented based on how the data is structured in the response
    private static List<Double> parseJsonToValues(String jsonResponse, String columnToCheck) {
        List<Double> values = new ArrayList<>();
        // Implement parsing logic here
        return values;
    }
}