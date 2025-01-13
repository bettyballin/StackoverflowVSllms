/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Profiler_1 {
    public static void main(String[] stringArray) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        threadMXBean.setThreadContentionMonitoringEnabled(true);
        threadMXBean.dumpAllThreads(true, true);
    }
}
