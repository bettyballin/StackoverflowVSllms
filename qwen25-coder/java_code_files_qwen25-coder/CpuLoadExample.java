import java.lang.String;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class CpuLoadExample {
    public static void main(String[] args) throws InterruptedException {
        OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        
        while (true) {
            double systemCpuLoad = osBean.getSystemCpuLoad() * 100;
            System.out.println("System CPU Load: " + String.format("%.2f", systemCpuLoad) + "%");

            double processCpuLoad = osBean.getProcessCpuLoad() * 100;
            System.out.println("Process CPU Load: " + String.format("%.2f", processCpuLoad) + "%");
            
            // Sleep for a second
            Thread.sleep(1000);
        }
    }
}