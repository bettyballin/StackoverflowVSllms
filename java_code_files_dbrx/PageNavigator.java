import java.lang.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class PageNavigator {
    WebDriver driver = new ChromeDriver(); // or Firefox, IE whichever driver suits your needs.
    Boolean locationExist;
    String displayTitle;
    Boolean isDisplayNone;

    {
        //Navigate to page containing above displayed HTML
        driver.get("http://your-page-url.com"); // Replace with the actual URL

        locationExist = !driver.findElements(By.xpath("//div[contains(text(), 'Location') and contains(@id,'top-level-menu-item')]/parent::*")).isEmpty();
        displayTitle = driver.findElement(By.xpath("//div[contains(@class,'as-slave') and contains(text(), 'Title')]")).getAttribute("style");
        isDisplayNone = "display:none".equals(displayTitle);
    }
    
    public static void main(String[] args) {
    }
}