import java.lang.String;

public class SecurityManagerInitializer {

    static MySecurityManager mySecMan = new MySecurityManager();

    static {
        mySecMan.addBlacklistedMethod("someMethodName"); // add blacklisted methods here
        System.setSecurityManager(mySecMan);
    }

    public static void main(String[] args) {
    }
}

class MySecurityManager extends SecurityManager {
    public void addBlacklistedMethod(String methodName) {
        // implementation here
    }
}