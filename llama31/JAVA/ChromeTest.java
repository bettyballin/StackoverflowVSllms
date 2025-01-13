import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.example.com");
    // Perform actions on the web app
    driver.quit();
  }
}