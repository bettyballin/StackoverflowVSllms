import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class GetJavaProcessID {
    public static void main(String[] args) {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String pid = runtime.getName().split("@")[0];
        System.out.println("The process ID is: " + pid);
    }
}