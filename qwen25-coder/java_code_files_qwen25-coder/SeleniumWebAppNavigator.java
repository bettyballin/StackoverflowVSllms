import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class SeleniumWebAppNavigator {
    // Example of Selenium in Java to navigate to a webpage and input data
    public static void main(String[] args) {
       WebDriver driver = new ChromeDriver();
       driver.get("http://your-web-app-url");
       WebElement inputField = driver.findElement(By.id("inputId"));
       inputField.sendKeys("testData");
       WebElement button = driver.findElement(By.id("buttonId"));
       button.click();
    }
}