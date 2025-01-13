/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MainClassFinder {
    public static String getMainClassName() {
        ThreadInfo[] threadInfoArray;
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        for (ThreadInfo threadInfo : threadInfoArray = threadMXBean.dumpAllThreads(true, true)) {
            StackTraceElement[] stackTraceElementArray;
            if (threadInfo.getThreadId() == Thread.currentThread().getId() || !threadInfo.getThreadName().equals("main") || (stackTraceElementArray = threadInfo.getStackTrace()).length <= 0) continue;
            return stackTraceElementArray[0].getClassName();
        }
        return null;
    }

    public static void main(String[] stringArray) {
        System.out.println(MainClassFinder.getMainClassName());
    }
}
