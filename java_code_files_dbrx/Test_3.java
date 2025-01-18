import java.lang.String;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test_3 {
  public static void main(String[] args) throws IOException {
    Document doc = Jsoup.connect("http://your-website/").get();
    String html = doc.html(); //This will always be in UTF8 even if the source page was in a different charset
  }
}