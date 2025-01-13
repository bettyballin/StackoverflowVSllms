import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest_67_67 {

    @Test
    public void test() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        TimeUnit.SECONDS.sleep(3);
        driver.quit();
    }

    public static void main(String[] args) {
        // This main method is empty and does not run the test.
        // JUnit tests are typically run with a test runner, not directly.
    }
}