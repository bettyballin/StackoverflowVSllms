import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReaderorUrlFileReader {
    BufferedReader reader;
    ArrayList<String> words = new ArrayList<>();
    String strFile = getParameter("fileToRead");

    {
        try {
            URL url = new URL(strFile);
            InputStream is = url.openStream();
            reader = new BufferedReader(new InputStreamReader(is));

            String input;
            while ((input = reader.readLine()) != null) {
                words.add(input);
            }
            reader.close();
        } catch (IOException e) {
            Logger.getLogger(FileReaderorUrlFileReader.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String getParameter(String paramName) {
        // For now, we return a string value
        return "http://example.com/file.txt";
    }

    public static void main(String[] args) {
    }
}