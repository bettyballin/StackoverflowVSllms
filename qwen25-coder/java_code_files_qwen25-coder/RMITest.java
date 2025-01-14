import java.lang.String;
import javax.naming.InitialContext;
import java.util.Properties;

public class RMITest {

    public static void main(String[] args) {
        // Load properties from your property file or configure them directly.
        Properties env = new Properties();
        env.put("java.naming.factory.initial", "oracle.j2ee.rmi.RMIInitialContextFactory");
        env.put("java.naming.security.principal", "user");
        env.put("java.naming.security.credentials", "pass");
        env.put("java.naming.provider.url", "ormi://hostname:port/application");

        boolean isConnected = isConnected(env);
        System.out.println("Connected to RMI server: " + isConnected);
    }

    public static boolean isConnected(Properties environment) {
        try {
            // Attempt to create an InitialContext with the provided properties.
            InitialContext ctx = new InitialContext(environment);
            // Once created, close it if no further operations are needed.
            ctx.close();
            return true;
        } catch (Exception e) {
            // Catch any exceptions that occur during context creation and report as not connected.
            e.printStackTrace();
            return false;
        }
    }
}