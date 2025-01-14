import java.lang.String;
public class Application_4 {
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            e.printStackTrace(); // This prints the stack trace, showing the complete path of execution leading to the error.
        }
    }

    private static void methodA() {
        methodB();
    }

    private static void methodB() {
        methodC();
    }

    private static void methodC() {
        throw new RuntimeException("Something went wrong!");
    }
}