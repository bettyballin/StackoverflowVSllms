import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class GetPID {
    public static void main(String[] args) {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String pidString = runtime.getName().split("@")[0];
        long pid = Long.parseLong(pidString);
        System.out.println("Current process PID: " + pid);
    }
}