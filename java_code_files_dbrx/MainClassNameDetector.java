import java.lang.String;
public class MainClassNameDetector {
public static String getMainClassName() {
    StackTraceElement[] stackTrace = new Exception().getStackTrace();
    for (int i = 0; i < stackTrace.length; ++i)
        if ("main".equals(stackTrace[i].getMethodName()))
            return stackTrace[i + 2].getClassName();
    throw new IllegalStateException("No main method detected");
}
	public static void main(String[] args) {
	}
}