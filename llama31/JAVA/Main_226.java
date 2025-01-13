import org.jsoup.Jsoup;

public class Main_226 {
    public static void main(String[] args) {
        String jsFile = "path/to/your/javascript/file.js";
        String minifiedJs = Jsoup.minifyBody(jsFile, null);

        // Use the minified JavaScript
        System.out.println(minifiedJs);
    }
}