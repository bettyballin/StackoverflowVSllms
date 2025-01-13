/*
 * Decompiled with CFR 0.152.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class MainClassFinder_1 {
    public static String getMainClassName() {
        String[] stringArray;
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        for (String string : stringArray = runtimeMXBean.getInputArguments().toArray(new String[0])) {
            if (string.startsWith("-classpath") || string.startsWith("-cp")) continue;
            if (string.endsWith(".jar")) {
                return string.substring(0, string.length() - 4);
            }
            return string;
        }
        return null;
    }

    public static void main(String[] stringArray) {
        System.out.println(MainClassFinder_1.getMainClassName());
    }
}
