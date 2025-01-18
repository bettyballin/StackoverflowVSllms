// Example Using Selenium/WebDriver with Java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class Example {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.example.com"); // replace it by your site URL - this will navigate to the home page
        driver.findElement(By.linkText("Sample Link Text")).click(); // replace the link text based on your requirement
        String expectedTitle = "Expected Title"; // Define your expected title here
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }
}