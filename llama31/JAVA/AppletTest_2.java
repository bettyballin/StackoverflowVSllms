import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppletTest_2_2 {
    public static void main(String[] args) {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to the applet page
        driver.get("http://example.com/applet.html");

        // Get the applet element
        WebElement applet = driver.findElement(By.xpath("//applet"));

        // Simulate user interactions
        applet.findElement(By.xpath("//button[@name='login']")).click();
        applet.findElement(By.xpath("//input[@name='username']")).sendKeys("username");
        applet.findElement(By.xpath("//input[@name='password']")).sendKeys("password");

        // Verify the result
        WebElement result = applet.findElement(By.xpath("//label[@name='result']"));
        System.out.println(result.getText());

        // Close the WebDriver
        driver.quit();
    }
}