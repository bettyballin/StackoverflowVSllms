import java.lang.String;
import java.lang.SecurityManager;
import java.lang.ThreadLocal;

public class NativeRMISecurityManager_1_1 extends SecurityManager {
    // ...

    private static InheritableThreadLocal<String> user = new InheritableThreadLocal<>();

    public NativeRMISecurityManager_1(final String user) {
        super();
        // ...
        NativeRMISecurityManager_1.user.set(user);
    }

    // ...

    public static void main(String[] args) {
    }
}