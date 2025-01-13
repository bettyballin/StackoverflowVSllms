/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class ProcessNameSetter {
    public static void main(String[] stringArray) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String string = "MyProgram";
        System.setProperty("sun.java.command", string);
    }
}
