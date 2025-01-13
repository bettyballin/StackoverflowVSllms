/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

public class ClassLoaderMonitor {
    public static void main(String[] stringArray) {
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        System.out.println("Loaded classes: " + classLoadingMXBean.getLoadedClassCount());
        System.out.println("Unloaded classes: " + classLoadingMXBean.getUnloadedClassCount());
    }
}
