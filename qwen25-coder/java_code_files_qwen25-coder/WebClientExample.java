import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

public class WebClientExample {
    public static void main(String[] args) throws Exception {
        try (final WebClient webClient = new WebClient()) {
            // Enable JavaScript and CSS if needed
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.waitForBackgroundJavaScript(10000); // wait for 10 seconds

            HtmlPage myPage = webClient.getPage("https://labserver.comp.com/mcwebadm/cgi-bin/edit_local.pl?operation=edit&return_address=%2Fmcwebadm%2Fcgi-bin%2Fmenu.pl&selected=2322020c341b11de96c3000423d43f1d");
            HtmlForm tempForm = myPage.getFormByName("menu_form");

            // Ensure the form and inputs are loaded
            webClient.waitForBackgroundJavaScript(5000); // additional wait if necessary

            tempForm.getInputByName("userId").setValueAttribute("myusername");

            HtmlElement submitButton = tempForm.getInputByName("submit_button");
            HtmlPage editSubscriberPage = submitButton.click();

            // Optional: Wait for JavaScript to fully execute after the form submission
            webClient.waitForBackgroundJavaScript(10000);
        }
    }
}