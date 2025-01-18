import java.lang.String;
import java.io.*;

public class Main_105 {
    public static void main(String[] args) throws IOException {
        // Given memory stream with String
        ByteArrayInputStream byteStream = new ByteArrayInputStream("Hello World".getBytes());

        // Read the data from InputStream to a string
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(byteStream, "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }
        String result = builder.toString();

        System.out.println("Output: " + result); // prints Hello World
    }
}