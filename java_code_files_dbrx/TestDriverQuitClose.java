import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriverQuitClose {
    public static void main(String[] args) {
        // Assume that 'driver' has been initialized and used for test execution
        WebDriver driver = new ChromeDriver();

        // Perform test actions here
        // ...

        // To ensure that all tests have stopped and no more actions are pending, call the below lines after your test execution is done, before quitting or stopping Selenium Driver.
        driver.quit();  // This will stop WebDriver session gracefully with all its windows closed.
        //or
        // driver.close();   // If you want to close just the active window in focus.
    }
}