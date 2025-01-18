import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class ResourceReader {
    InputStream input = getClass().getResourceAsStream("/resource/myFileName");
    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
    String str, text="";
    {
        try {
            while ((str = reader.readLine()) != null){ //iterate till last line
                text += "\n" + str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}