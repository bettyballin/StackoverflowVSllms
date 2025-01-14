import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileReaderApplet {
    public void readFileFromServer(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);  // or process it as needed
        }
        reader.close();
    }

    public static void main(String[] args) {
        try {
            FileReaderApplet applet = new FileReaderApplet();
            // Example URL, replace with your server file URL
            applet.readFileFromServer("http://example.com/kb1.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}