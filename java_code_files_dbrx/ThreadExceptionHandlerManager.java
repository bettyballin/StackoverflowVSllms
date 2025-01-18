import java.lang.String;
public class ThreadExceptionHandlerManager {
public static void main(String[] args) {
    Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
        throwable.printStackTrace();
    });
}
}