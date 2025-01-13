import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main_227 {
    public static void main(String[] args) {
        // Assuming driver is initialized and navigated to the webpage
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com"); // replace with your URL
        
        List<WebElement> allElements = driver.findElements(By.xpath("//*"));

        for (WebElement element : allElements) {
            String xpath = getElementXPath(element);
            System.out.println(xpath);
        }
        
        driver.quit();
    }

    public static String getElementXPath(WebElement element) {
        String xpath = "";
        for (WebElement parent = element; parent != null; parent = parent.findElement(By.xpath(".."))) {
            String tag = parent.getTagName();
            if (tag.equals("html")) {
                break;
            }
            xpath = "/" + tag + xpath;
        }
        xpath = "/" + element.getTagName() + xpath;
        return xpath;
    }
}