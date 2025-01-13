import net.rim.device.api.applicationcontrol.ApplicationManager;
import net.rim.device.api.applicationcontrol.ApplicationManagerListener;
import net.rim.device.api.applicationcontrol.ApplicationState;
import net.rim.device.api.ui.UiApplication;

public class MyApp_1 extends UiApplication implements ApplicationManagerListener {
    public MyApp() {
        ApplicationManager appManager = ApplicationManager.getApplicationManager();
        appManager.addListener(this);
    }

    public void stateChanged(ApplicationManager manager, ApplicationState state) {
        if (state == ApplicationState.INSTALLED) {
            // Run your application logic here
            injectMenuItems();
        }
    }

    private void injectMenuItems() {
        // Code to inject menu items into other applications
    }

    public static void main(String[] args) {
        new MyApp().enterEventDispatcher();
    }
}