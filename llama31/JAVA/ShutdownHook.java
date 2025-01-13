import java.lang.String;
import java.lang.Runtime;
import javax.naming.Naming;

public class ShutdownHook {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    Naming.unbind("yourObjectName");
                } catch (Exception e) {
                    // Handle exception
                }
            }
        });
    }

    public static void main(String[] args) {
    }
}