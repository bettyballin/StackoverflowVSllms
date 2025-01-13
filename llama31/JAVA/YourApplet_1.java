import java.applet.Applet;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.RuntimePermission;

public class YourApplet_1_1 extends Applet {
    // ...

    public void uploadFile() {
        // Check if the applet has the required permissions
        if (AccessController.checkPermission(new RuntimePermission("setFactory"))) {
            // Perform the upload
        } else {
            // Handle the permission denial
        }
    }

    public static void main(String[] args) {
    }
}