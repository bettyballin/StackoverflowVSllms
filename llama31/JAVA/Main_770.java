import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Main_770_770 {
    public static void main(String[] args) {
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        System.out.println("CPU usage: " + osBean.getSystemCpuLoad());
    }
}