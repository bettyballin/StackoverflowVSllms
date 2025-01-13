import java.io.FilePermission;
import java.net.MalformedURLException;
import java.security.CodeSource;
import java.security.Permission;
import java.security.Policy;
import java.security.cert.Certificate;

public class Main_139 {
    public static void main(String[] args) {
        try {
            Policy policy = Policy.getPolicy();
            CodeSource codeSource = new CodeSource(new java.net.URL("file:///path/to/your/applet.jar"), (Certificate[]) null);
            Permission permission = new FilePermission("C:/test", "read");
            policy.addPermission(codeSource, permission);
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        } catch (SecurityException e) {
            System.err.println("Security Exception: " + e.getMessage());
        }
    }
}