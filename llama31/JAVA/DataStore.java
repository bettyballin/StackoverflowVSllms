import java.lang.String;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataStore {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.github.com/repos/username/repo/contents/file.csv");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        connection.disconnect();
    }
}