import java.lang.String;
public class ThreadUtils {
    public static String getMainClassName() {
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if ("main".equals(t.getName())) {
                for (StackTraceElement stackTraceElement : t.getStackTrace()) {
                    if ("main".equals(stackTraceElement.getMethodName())) {
                        return stackTraceElement.getClassName();
                    }
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
    }
}