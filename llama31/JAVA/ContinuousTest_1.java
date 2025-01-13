import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ContinuousTest_1_1 {
    @Test(invocationCount = 1000)
    public void runTestCase() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://example.com");
        WebElement element = driver.findElement(By.id("someElement"));
        element.click();
        driver.quit(); // Add this line to close the browser after each test
    }

    public static void main(String[] args) {
        org.testng.TestNG testng = new org.testng.TestNG();
        testng.setTestClasses(new Class[] { ContinuousTest_1.class });
        testng.run();
    }
}