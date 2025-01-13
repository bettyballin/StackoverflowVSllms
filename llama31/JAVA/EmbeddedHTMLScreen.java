import java.lang.String;
import net.rim.device.api.browser.field.BrowserField;
import net.rim.device.api.browser.field.BrowserFieldConfig;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.MainScreen;

public class EmbeddedHTMLScreen extends MainScreen {
    private BrowserField browserField;

    public EmbeddedHTMLScreen() {
        BrowserFieldConfig config = new BrowserFieldConfig();
        browserField = new BrowserField(config);
        add(browserField);
        browserField.requestContent("http://www.example.com");
    }

    public static void main(String[] args) {
        UiApplication app = new UiApplication();
        app.pushScreen(new EmbeddedHTMLScreen());
        app.enterEventDispatcher();
    }
}