import java.util.Set;
import java.lang.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenIDLoginHandler {
    static WebDriver driver;

    public static void main(String[] args) {
        // Store the window handle before you click on the button that opens the Open ID page
        String mainWindow = driver.getWindowHandle();
    
        // Click the button that opens the OpenID page
        driver.findElement(By.id("openIdButton")).click();
    
        // Switch to the new Window
        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
    
        // Perform your OpenID login actions
        driver.findElement(By.id("email")).sendKeys("example@example.com");
        driver.findElement(By.id("password")).sendKeys("mypassword123");
        driver.findElement(By.id("signin-button")).click();
    
        // Switch back to the main window
        driver.switchTo().window(mainWindow);
    }
}