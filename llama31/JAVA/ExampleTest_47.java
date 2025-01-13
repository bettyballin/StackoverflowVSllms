import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_47_47 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Specify the path to chromedriver
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        TimeUnit.SECONDS.sleep(3);
        driver.quit();
    }
}