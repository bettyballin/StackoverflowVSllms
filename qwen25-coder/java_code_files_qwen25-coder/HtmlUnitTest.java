import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlUnitTest {
    public static void main(String[] args) throws Exception {
        try (WebClient webClient = new WebClient()) {
            // Enable JavaScript support if necessary, otherwise leave it false
            webClient.getOptions().setJavaScriptEnabled(false);
            
            // Load your page
            HtmlPage page = webClient.getPage("http://your-application-url.com");

            // Perform assertions or actions
            String title = page.getTitleText();
            System.out.println("Title of the page is: " + title);

            // You can also interact with elements, submit forms etc.
        }
    }
}