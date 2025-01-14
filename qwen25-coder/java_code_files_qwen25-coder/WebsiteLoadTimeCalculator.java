import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.LogType;

public class WebsiteLoadTimeCalculator {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

        ChromeOptions options = new ChromeOptions();
        options.setCapability("goog:loggingPrefs", logPrefs);

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        String url = "http://example.com";
        long startTime = 0;
        long endTime = 0;

        try {
            driver.get(url);
            startTime = getNavigationStart(driver);
            endTime = getLoadEventEnd(driver);
        } catch (Exception e) {
            System.out.println("Error loading page: " + e.getMessage());
        }

        driver.quit();

        double loadTime = (endTime - startTime) / 1000.0; // Convert milliseconds to seconds
        System.out.println("Page Load Time: " + loadTime + " seconds");
    }

    private static long getNavigationStart(ChromeDriver driver) {
        Logs logs = driver.manage().logs();
        List<LogEntry> logEntries = logs.get(LogType.PERFORMANCE).getAll();

        for (LogEntry entry : logEntries) {
            String message = entry.getMessage();
            if (message.contains("Page.timing.loadEventEnd")) {
                // Parsing is simplified. Full parsing can be improved.
                return Long.parseLong(message.split(",")[5].split(":")[1]);
            }
        }

        throw new RuntimeException("Navigation start time not found");
    }

    private static long getLoadEventEnd(ChromeDriver driver) {
        Logs logs = driver.manage().logs();
        List<LogEntry> logEntries = logs.get(LogType.PERFORMANCE).getAll();

        for (LogEntry entry : logEntries) {
            String message = entry.getMessage();
            if (message.contains("Page.timing.loadEventEnd")) {
                return Long.parseLong(message.split(",")[2].split(":")[1]);
            }
        }

        throw new RuntimeException("Load event end time not found");
    }
}