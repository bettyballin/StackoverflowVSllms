import java.applet.Applet;
import java.security.Policy;
import java.security.Permission;
import java.io.FilePermission;
import java.lang.RuntimePermission;

public class YourApplet extends Applet {
    // ...

    public void init() {
        // Grant the required permissions
        Policy policy = Policy.getPolicy();
        policy.addPermission(new RuntimePermission("setFactory"));
        policy.addPermission(new FilePermission("<<ALL FILES>>", "read"));
    }

	public static void main(String[] args) {
	}
}