import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SeleniumExample {
    public static void main(String[] args) {
        // Create a new instance of the HtmlUnit driver
        WebDriver driver = new HtmlUnitDriver();

        // Navigate to the page
        driver.get("https://your-intranet-page.com");

        // Get the page source
        String pageSource = driver.getPageSource();

        // Parse the DOM using your preferred method (e.g., Jsoup)
        System.out.println(pageSource); // Print the page source to console
    }
}