import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class NonJavaScriptTest {
    public static void main(String[] args) throws Exception {
        // Initialize WebClient and disable JavaScript
        try (final WebClient webClient = new WebClient()) {
            webClient.getOptions().setJavaScriptEnabled(false);

            // Open the target URL without executing JavaScript
            final HtmlPage page = webClient.getPage("http://your-test-site.com");

            // Perform assertions or checks on the page
            String pageTitle = page.getTitleText();
            System.out.println("Page Title: " + pageTitle);
            // Add more tests as needed
        }
    }
}