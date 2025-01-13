/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class RunningInstances {
    public static void main(String[] stringArray) {
        ThreadInfo[] threadInfoArray;
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        for (ThreadInfo threadInfo : threadInfoArray = threadMXBean.dumpAllThreads(true, true)) {
            System.out.println("Thread Name: " + threadInfo.getThreadName());
            System.out.println("Thread ID: " + threadInfo.getThreadId());
            System.out.println("Thread State: " + String.valueOf((Object)threadInfo.getThreadState()));
            System.out.println("Stack Trace:");
            for (StackTraceElement stackTraceElement : threadInfo.getStackTrace()) {
                System.out.println("  " + String.valueOf(stackTraceElement));
            }
            System.out.println();
        }
    }
}
