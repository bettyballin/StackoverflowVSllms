import java.lang.String;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.lang.management.ManagementFactory;

public class MainClassFinder {
    public static String getMainClassName() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);
        
        for (ThreadInfo threadInfo : threadInfos) {
            if (threadInfo.getThreadId() == Thread.currentThread().getId()) {
                continue; // skip current thread
            }
            if (threadInfo.getThreadName().equals("main")) {
                StackTraceElement[] stackTrace = threadInfo.getStackTrace();
                if (stackTrace.length > 0) {
                    return stackTrace[0].getClassName();
                }
            }
        }
        return null; // main class not found
    }

    public static void main(String[] args) {
        System.out.println(getMainClassName());
    }
}