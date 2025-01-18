import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class FirstTest {

    private WebDriver driver;

    @Before
    public void setup() throws InterruptedException {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // A simple Selenium test to check if the webpage loads successfully or not
    @Test
    public void TestWeb() throws IOException {
        final String URL = "<your website url>";
        driver.get(URL);

        // Get the HTTP status code
        int statusCode = getHTTPResponseStatusCode(URL);

        // Assert that the loading is successful
        Assert.assertEquals(200, statusCode); // Assert that the loading is successful
    }

    // Helper method to get the HTTP status code
    private int getHTTPResponseStatusCode(String url) throws IOException {
        HttpURLConnection http = (HttpURLConnection) (new URL(url).openConnection());
        http.setRequestMethod("HEAD");
        http.connect();
        int code = http.getResponseCode();
        http.disconnect();
        return code;
    }
}