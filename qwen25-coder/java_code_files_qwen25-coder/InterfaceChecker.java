import java.lang.String;

public class InterfaceChecker {

    static Object object = new Object();

    interface YourInterface {
        // Interface methods
    }

    static {
        if (object instanceof YourInterface) {
            // The object implements YourInterface
        }
    }

    public static void main(String[] args) {
    }
}