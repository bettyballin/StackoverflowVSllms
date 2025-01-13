/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadDebugger {
    public static void main(String[] stringArray) {
        ThreadInfo[] threadInfoArray;
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        for (ThreadInfo threadInfo : threadInfoArray = threadMXBean.dumpAllThreads(true, true)) {
            if (!threadInfo.getThreadName().contains("ImageFetcher")) continue;
            System.out.println("Thread Name: " + threadInfo.getThreadName());
            System.out.println("Thread State: " + String.valueOf((Object)threadInfo.getThreadState()));
            System.out.println("Stack Trace:");
            for (StackTraceElement stackTraceElement : threadInfo.getStackTrace()) {
                System.out.println("  " + stackTraceElement.toString());
            }
        }
    }
}
