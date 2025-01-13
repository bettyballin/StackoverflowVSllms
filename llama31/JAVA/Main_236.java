import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Main_236 {
    public static void main(String[] args) throws Exception {
        WebClient webClient = new WebClient();
        HtmlPage page = webClient.getPage("https://example.com");
        webClient.waitForBackgroundJavaScript(10 * 1000); // wait for 10 seconds
        webClient.close();
    }
}