import java.lang.String;
import java.io.IOException;

public class PluginLoader {

    public static void main(String[] args) {
        // Initialize the Security Manager with the defined policy.
        String policyFile = "myapp.policy";  
        System.setProperty("java.security.policy", policyFile);
        SecurityManager securityManager = new SecurityManager(); 
        System.setSecurityManager(securityManager); 

        // Now load your plugin using JPF or your custom mechanism
        // ...
    }

    public static void someMethodThatAttemptsToStartProcess() {
        try {
            Runtime.getRuntime().exec("ls");
        } catch (SecurityException se) {
            System.out.println("Attempt to start a process was blocked: " + se.getMessage());
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}