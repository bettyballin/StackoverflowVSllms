import java.applet.Applet;
import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class MyApplet extends Applet {
    public void init() {
        // ...
        File file = new File("kb1.xml");
        PrivilegedAction<Void> action = new PrivilegedAction<Void>() {
            public Void run() {
                // Read the file here
                // ...
                return null;
            }
        };
        AccessController.doPrivileged(action);
    }

	public static void main(String[] args) {
	}
}