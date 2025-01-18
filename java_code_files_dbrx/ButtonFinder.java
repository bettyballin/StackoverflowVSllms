import java.lang.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class ButtonFinder {
    WebDriver driver;
    WebElement myButton = driver.findElement(By.id("buttonId"));
    public static void main(String[] args) {
    }
}