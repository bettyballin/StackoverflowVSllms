// No changes needed to the Java code itself
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class Main_374 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com");

        // Cast WebDriver to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        screenshot.getScreenshotAs(OutputType.FILE).renameTo(new File("output.png")); // Corrected method name here

        driver.quit();
    }
}