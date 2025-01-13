/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Main_189 {
    public static void main(String[] stringArray) {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        String string = operatingSystemMXBean.getName();
        System.out.println(string);
    }
}
