import java.lang.String;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage {
    @FindBy(name = "q")
    private WebElement searchBox;

    public void enterQuery(String query) {
        searchBox.sendKeys(query);
    }

    public static void main(String[] args) {
    }
}