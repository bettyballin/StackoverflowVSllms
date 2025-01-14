import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CssSelectorExample {
    // Using CSS Selector
    WebDriver driver;

    {
        driver.findElement(By.cssSelector("input[name='q']"));
    }

    public static void main(String[] args) {
    }
}