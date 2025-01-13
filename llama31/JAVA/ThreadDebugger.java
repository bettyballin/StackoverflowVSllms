import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.lang.management.ThreadInfo;

public class ThreadDebugger {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);

        for (ThreadInfo threadInfo : threadInfos) {
            if (threadInfo.getThreadName().contains("ImageFetcher")) {
                System.out.println("Thread Name: " + threadInfo.getThreadName());
                System.out.println("Thread State: " + threadInfo.getThreadState());
                System.out.println("Stack Trace:");
                for (StackTraceElement element : threadInfo.getStackTrace()) {
                    System.out.println("  " + element.toString());
                }
            }
        }
    }
}