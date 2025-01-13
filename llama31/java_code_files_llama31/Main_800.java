/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;

public class Main_800 {
    public static void main(String[] stringArray) {
        String string = ManagementFactory.getRuntimeMXBean().getName();
        String string2 = string.split("@")[0];
        System.out.println("Process ID: " + string2);
    }
}
