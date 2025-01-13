import java.lang.String;
import java.lang.Set;
import java.lang.Permission;
import java.lang.SecurityManager;
import java.lang.Thread;

public class ThreadAwareSecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof MySpecialThread) {
            // Apply special security policy for MySpecialThread
            // ...
        } else {
            // Apply default security policy
            super.checkPermission(perm);
        }
    }

    public static void main(String[] args) {
        // Set the custom SecurityManager
        System.setSecurityManager(new ThreadAwareSecurityManager());
    }
}

class MySpecialThread extends Thread {
    // ...
}