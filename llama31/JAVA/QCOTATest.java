import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

public class QCOTATest {
    public static void main(String[] args) {
        // Initialize JACOB
        ActiveXComponent.initialize();

        // Create a Dispatch object for the QC OTA API
        Dispatch qcApp = new Dispatch("QCApplication");

        // Call a method on the QC OTA API
        qcApp.invoke("Login", "username", "password");

        // Release resources
        qcApp.safeRelease();
        ActiveXComponent.uninitialize();
    }
}