import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class Main_820 {
    public static void main(String[] args) {
        // Set up the WebDriver
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath("C:\\Path\\To\\Your\\Application.exe");
        WebDriver driver = new WiniumDriver(options);

        // Find an element and click it
        WebElement element = driver.findElement(By.name("Button1"));
        element.click();

        // Close the WebDriver
        driver.quit();
    }
}