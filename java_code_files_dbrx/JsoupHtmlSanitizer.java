import org.jsoup.Jsoup;

public class JsoupHtmlSanitizer {
    String unsafe = "<p>blah</p><script>alert('Malicous script!')</" + "script>";
    String safe = Jsoup.parse(unsafe).text(); // yields 'blah'
    
    public static void main(String[] args) {
    }
}