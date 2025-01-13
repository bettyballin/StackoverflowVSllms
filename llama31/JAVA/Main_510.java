import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Main_510 {
    public static void main(String[] args) throws Exception {
        // Setting up the WebClient
        WebClient webClient = new WebClient();
        
        // Getting the page
        HtmlPage page = webClient.getPage("http://example.com");
        
        // It's good practice to close the WebClient after use
        webClient.close();
    }
}