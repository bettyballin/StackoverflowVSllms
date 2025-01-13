import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
  public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
    WebDriver driver = new FirefoxDriver();
    driver.get("file:///path/to/your/testcase.html");
    driver.quit();
  }
}