import java.lang.String;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Example_17_17 {
    public static void main(String[] args) throws Exception {
        WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage("http://example.com");
        // perform actions on the page
        webClient.closeAllWindows();
    }
}