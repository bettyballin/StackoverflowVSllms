// The necessary imports
import java.lang.String;

// Declare the annotations
@interface BTrace {}

@interface OnMethod {
    String clazz();
    String method();
}

@interface ProbeClassName {}

@interface ProbeMethodName {}

// Declare the BTraceUtils class
class BTraceUtils {
    public static void print(String msg) {
        System.out.print(msg);
    }
    public static void println(String msg) {
        System.out.println(msg);
    }
    public static void jstack() {
        Thread.dumpStack();
    }
}

// Now the main class
@BTrace
public class Log4jTracer {

    @OnMethod(
        clazz="org.apache.log4j.Logger",
        method="getLogger"
    )
    public static void onGetLogger(@ProbeClassName String className, @ProbeMethodName String methodName) {
        BTraceUtils.print("Logger created for: " + className);
        BTraceUtils.jstack();
    }

    @OnMethod(
        clazz="org.apache.log4j.FileAppender",
        method="setFile"
    )
    public static void onSetFile(String fileName) {
        BTraceUtils.println("Setting log file to: " + fileName);
        BTraceUtils.jstack();
    }

    public static void main(String[] args) {
    }
}