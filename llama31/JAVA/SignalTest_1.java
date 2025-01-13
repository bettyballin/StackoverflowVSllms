import java.lang.String;
public class SignalTest_1 {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                // shutdown code here
            }
        });

        // ...
    }
}