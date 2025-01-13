import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_59_59 {

    public static void main(String[] args) throws InterruptedException {
        ExampleTest_59 test = new ExampleTest_59();
        test.test();
    }

    public void test() throws InterruptedException {
        // Ensure you have the correct path to the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        TimeUnit.SECONDS.sleep(3);
        driver.quit();
    }
}