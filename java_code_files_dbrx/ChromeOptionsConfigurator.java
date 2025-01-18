import java.lang.String;
public class ChromeOptionsConfigurator {

    ChromeOptions chromeOptions;
    WebDriver driver;

    public ChromeOptionsConfigurator() {
        chromeOptions = new ChromeOptions();
        chromeOptions.setEnabled(false); // <--------------- Disables Javascript in browser before test
        driver = new ChromeDriver(chromeOptions);
    }

    public static void main(String[] args) {
    }
}