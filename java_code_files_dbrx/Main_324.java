import org.json.*;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        JSONObject obj = new JSONObject(new JSONTokener(new FileReader("/path/to/file")));
        int numClicks1 = obj.getInt("clickArea1");
        int numClicks2 = obj.getInt("clickArea2");
    }
}