import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class JsonSanitizer {
    static String jsonObject = "..."; // Your JSON data here
    static String output = Jsoup.clean(jsonObject, Whitelist.none()); // Encode your JSON here before printing or storing in DB/cookies etc.

    static {
        System.out.print(output);
    }

    public static void main(String[] args) {
    }
}