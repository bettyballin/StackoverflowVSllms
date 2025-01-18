import java.lang.String;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebpageLoadTime {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/path/to/your/chromedriver"); // Update with path to your Chrome driver

        StopWatch stopwatch = new StopWatch();

        WebDriver driver = new ChromeDriver();

        int numIterations = 5; // Update this value based on how many times you want to access the website and calculate mean load time.

        long[] loadTimes = new long[numIterations];

        for (int i = 0; i < numIterations; i++) {
            stopwatch.reset();
            stopwatch.start();

            driver.get("https://example.com"); // Update with the website address you want to test

            // Sleep is needed because Selenium may report that document has been loaded, but JS files and images are still loading.
            Thread.sleep(5000);

            stopwatch.stop();
            loadTimes[i] = stopwatch.getTime();
            driver.navigate().refresh(); // Refresh the page once for every iteration.
        }

        long sumOfLoadTimes = 0;
        for (long time : loadTimes) {
            sumOfLoadTimes += time;
        }
        System.out.println("Mean Load Time: " + ((float)sumOfLoadTimes / numIterations)); // Calculate mean and print output.
    }
}