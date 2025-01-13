import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class FileReader_2_2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("fileToRead"); // Note: getParameter is not a standard Java method, 
                                        // I assume you meant to pass the URL as a string
        BufferedReader file = new BufferedReader(new InputStreamReader(url.openStream()));
        ArrayList<String> words = new ArrayList<>();

        String input = "";
        while ((input = file.readLine()) != null) {
            words.add(input);
        }
        file.close(); // Close the BufferedReader to prevent resource leak
    }
}