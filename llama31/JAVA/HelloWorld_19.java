import java.lang.String;
// BlackBerry Java SDK example
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class HelloWorld_19 extends UiApplication {
    public static void main(String[] args) {
        HelloWorld app = new HelloWorld();
        app.enterEventDispatcher();
    }

    public HelloWorld() {
        MainScreen mainScreen = new MainScreen();
        LabelField label = new LabelField("Hello, World!");
        mainScreen.add(label);
        pushScreen(mainScreen);
    }
}