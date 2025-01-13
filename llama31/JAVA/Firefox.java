import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Firefox {
    public static void main(String[] args) {
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");
        WebDriver driver = new FirefoxDriver(myprofile);
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Hello");
        driver.findElement(By.name("btnK")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit(); // Add this line to close the browser
    }
}