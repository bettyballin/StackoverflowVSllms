import java.lang.String;
import java.lang.Thread;

public class ExceptionHandler {
    static {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                // Handle the exception and prevent the JVM from crashing
            }
        });
    }

    public static void main(String[] args) {
    }
}