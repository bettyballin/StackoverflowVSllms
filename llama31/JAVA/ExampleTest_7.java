import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_7_7 {

    public static void main(String[] args) throws InterruptedException {
        // Ensure the ChromeDriver is in your PATH or provide the path to it
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        TimeUnit.SECONDS.sleep(3);
        driver.quit();
    }
}