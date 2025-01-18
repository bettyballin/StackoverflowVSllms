import java.util.regex.Pattern;

public class BrowserVersionExtractor {
    Pattern p = Pattern.compile("(?<=\\()[^;]*(.*?)"); //Matches the browser name and version (e.g., Chrome/89.0)
    public static void main(String[] args) {
    }
}