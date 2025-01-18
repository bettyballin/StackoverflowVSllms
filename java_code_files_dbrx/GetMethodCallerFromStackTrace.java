import java.lang.String;
public class GetMethodCallerFromStackTrace {
    String callingMethodName = "";
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (int i = 1; i < stackTraceElements.length; i++) {
            if (!(stackTraceElements[i].getClassName()).startsWith("java") && !(stackTraceElements[i].getClassName()).equals("myPackageB")) {
                // This will print the method which called procedure in package B from package A
                callingMethodName = stackTraceElements[i].toString();
                break;
            }
        }
    }
    public static void main(String[] args) {
    }
}