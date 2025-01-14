import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    // Define a simple Log class to simulate Android's Log.i
    static class Log {
        public static void i(String tag, String message) {
            System.out.println(tag + ": " + message);
        }
    }

    public static void main(String[] args) {
        new Main().Login();
    }

    private void Login() {
        try {
            URL url = new URL("http://192.168.1.5:8000/YourService/Login?username=test&password=test");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                Log.i("login", "received " + response.toString());
            } else {
                Log.i("login", "Unsuccessful: Received error code: "
                        + httpURLConnection.getResponseCode());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}