import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyAutomatedTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver(); // or ChromeDriver() or InternetExplorerDriver(), etc.
        driver.get("http://www.google.com"); // navigate to a page
        WebElement element = driver.findElement(By.id("something")); // find an element with id 'something'
        element.sendKeys("text here"); // enter text into the text field
        driver.quit(); // dispose of the browser
    }
}