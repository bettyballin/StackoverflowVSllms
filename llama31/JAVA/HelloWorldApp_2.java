import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class HelloWorldApp_2_2 extends UiApplication {
    public HelloWorldApp_2() {
        MainScreen mainScreen = new MainScreen();
        LabelField labelField = new LabelField("Hello, World!");
        mainScreen.add(labelField);
        pushScreen(mainScreen);
    }

    public static void main(String[] args) {
        new HelloWorldApp_2().enterEventDispatcher();
    }
}