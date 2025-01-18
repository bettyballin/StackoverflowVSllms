import java.lang.String;
import java.security.Permission;
public class AppInitializer {
    public static void main(String[] args) {
        System.out.println("Starting the app...");

        System.setSecurityManager(new SecurityManager() {
            @Override public void checkPermission(Permission perm) {}
        });
        System.setProperty("-XX:-CreateCoredumpOnCrash", "");
    }
}