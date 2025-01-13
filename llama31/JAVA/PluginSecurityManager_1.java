import java.security.Permission;
import java.security.SecurityManager;
import javax.swing.JOptionPane;

public class PluginSecurityManager_1_1 extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        // Prompt the user for permission
        int dialogResult = JOptionPane.showConfirmDialog(null, "Allow plug-in to access " + perm.getName() + "?", "Permission Request", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.NO_OPTION) {
            throw new SecurityException("User denied permission");
        }
        super.checkPermission(perm);
    }

    public static void main(String[] args) {
        System.setSecurityManager(new PluginSecurityManager_1());
        // Test the security manager
        System.getProperty("user.home");
    }
}