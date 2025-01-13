import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Main_612_612 {
    public static void main(String[] args) {
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double cpuLoad = osBean.getSystemCpuLoad();
        System.out.println("Current CPU load: " + cpuLoad);
    }
}