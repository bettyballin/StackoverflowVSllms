import java.lang.String;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Main_189 {
    public static void main(String[] args) {
        OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        String osName = os.getName();
        System.out.println(osName);
    }
}