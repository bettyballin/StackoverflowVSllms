import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MultipartHttpPost {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://api.scribd.com/api");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=END_OF_FILE");

        String boundary = "END_OF_FILE";
        String fileName = "example.txt";
        File file = new File(fileName);

        connection.setDoOutput(true);
        OutputStream out = connection.getOutputStream();

        // Write metadata
        out.write(("--" + boundary + "\r\n").getBytes());
        out.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + fileName + "\"\r\n").getBytes());
        out.write(("Content-Type: text/plain\r\n\r\n").getBytes());

        // Write file contents
        FileInputStream fileIn = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileIn.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        fileIn.close();

        // Write boundary
        out.write(("\r\n--" + boundary + "--\r\n").getBytes());
        out.close();

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }
}