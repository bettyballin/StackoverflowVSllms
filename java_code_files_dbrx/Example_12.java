import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
    public static void main(String[] args) {
        // Set the path to your chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        // waiting time can be adjusted based on your requirements.
        // For example, if it takes more than 5 secs for the request,
        // then set timeout for a max of 10-15 secs to prevent tests from
        // getting failed due to latency issues.

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example")));
        // replace "example" with your AJAX element's id or xpath based on requirement
    }
}