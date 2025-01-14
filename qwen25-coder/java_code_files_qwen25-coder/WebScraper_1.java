import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebScraper_1 {
    public static void main(String[] args) {
        // Set the path to your chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("http://your-intranet-url.com");
            
            // Wait for the page to load and JavaScript to execute. You might need to add explicit waits.
            
            String pageSource = driver.getPageSource();
            System.out.println(pageSource);
        } finally {
            driver.quit();
        }
    }
}