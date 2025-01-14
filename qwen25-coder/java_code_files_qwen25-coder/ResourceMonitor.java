// Example Java snippet to monitor CPU usage using a simple library
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

public class ResourceMonitor {
    public static void main(String[] args) {
        SystemInfo si = new SystemInfo();
        CentralProcessor processor = si.getHardware().getProcessor();

        // Monitor the CPU load over time
        while (true) {
            double cpuLoad = processor.getSystemCpuLoadBetweenTicks();
            System.out.println("CPU Load: " + cpuLoad * 100);
            try {
                Thread.sleep(1000); // Check every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}