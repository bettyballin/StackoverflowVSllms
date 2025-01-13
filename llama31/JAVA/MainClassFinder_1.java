import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class MainClassFinder_1 {
    public static String getMainClassName() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String[] args = runtimeMXBean.getInputArguments().toArray(new String[0]);
        for (String arg : args) {
            if (arg.startsWith("-classpath") || arg.startsWith("-cp")) {
                continue;
            }
            if (arg.endsWith(".jar")) {
                return arg.substring(0, arg.length() - 4); // remove .jar extension
            } else {
                return arg;
            }
        }
        return null; // main class not found
    }

    public static void main(String[] args) {
        System.out.println(getMainClassName());
    }
}