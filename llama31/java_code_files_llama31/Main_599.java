/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Main_599 {
    public static void main(String[] stringArray) {
        String[] stringArray2;
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        for (String string : stringArray2 = runtimeMXBean.getInputArguments().toArray(new String[0])) {
            System.out.println(string);
        }
    }
}
