// Using JUnit
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GUITest {
    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://appurl";
    }

    @Test
    public void testGUI() throws Exception {
        // Navigate to your application
        driver.get(baseUrl);

        // Interact with UI elements, validate results
        driver.findElement(By.id("inputField")).sendKeys("test");
        assertEquals("Wrong text", "expectedText", driver.findElement(By.className("resultClass")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    public static void main(String[] args) {
    }
}