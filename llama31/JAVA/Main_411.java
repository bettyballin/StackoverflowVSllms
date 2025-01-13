import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Main_411 {
    public static void main(String[] args) {
        try {
            // Create a new instance of the WebClient
            WebClient webClient = new WebClient();

            // Navigate to the page
            HtmlPage page = webClient.getPage("https://your-intranet-page.com");

            // Get the page source
            String pageSource = page.asXml();

            // Parse the DOM using your preferred method (e.g., Jsoup)
            System.out.println(pageSource);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // You might want to close the WebClient here to free resources
        }
    }
}