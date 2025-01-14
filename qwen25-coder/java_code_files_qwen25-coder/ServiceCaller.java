import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceCaller {

    public String callService() {
        try {
            URL url = new URL("http://" + ServiceWrapper.SERVER_HOST + ":" + ServiceWrapper.SERVER_PORT + "/list");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
    
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
    
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
    
            in.close();
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
    }
}