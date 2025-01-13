import java.lang.String;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test_16 {

    public static void main(String[] args) {

        String result = "0";
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;

        try {
            url = new URL("http://www.something.com/myscript?param=xy");

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            dataInputStream = new DataInputStream(httpURLConnection
                    .getInputStream());
            dataOutputStream = new DataOutputStream(httpURLConnection
                    .getOutputStream());

            String content = "param=xy";

            dataOutputStream.writeBytes(content);
            dataOutputStream.flush();
            dataOutputStream.close();

            dataInputStream.close();

            int responseCode = httpURLConnection.getResponseCode();

            System.out.println("Response Code : " + responseCode);

        } catch (MalformedURLException e) {
            System.out.println("1. MalformedURLException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("2. IOException");
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
}