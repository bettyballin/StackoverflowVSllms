import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.lang.management.ThreadInfo;

public class RunningInstances {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);

        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("Thread Name: " + threadInfo.getThreadName());
            System.out.println("Thread ID: " + threadInfo.getThreadId());
            System.out.println("Thread State: " + threadInfo.getThreadState());
            System.out.println("Stack Trace:");
            for (StackTraceElement stackTraceElement : threadInfo.getStackTrace()) {
                System.out.println("  " + stackTraceElement);
            }
            System.out.println();
        }
    }
}