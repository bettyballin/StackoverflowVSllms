import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Main_599 {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String[] arguments = runtimeMXBean.getInputArguments().toArray(new String[0]);
        for (String arg : arguments) {
            System.out.println(arg);
        }
    }
}