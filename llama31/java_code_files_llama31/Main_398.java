/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Main_398 {
    public static void main(String[] stringArray) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        long l = runtimeMXBean.getUptime();
        System.out.println("JVM uptime: " + l + " milliseconds");
    }
}
