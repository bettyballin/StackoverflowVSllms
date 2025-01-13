import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchPage {
    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchButton() {
        // Using a robust XPath locator
        return driver.findElement(By.xpath("//input[@name='q']"));
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        WebElement searchButton = searchPage.getSearchButton();
        System.out.println(searchButton.getAttribute("name"));
        driver.quit();
    }
}