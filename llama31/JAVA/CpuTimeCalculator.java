import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class CpuTimeCalculator {
    public static void main(String[] args) {
        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long initialCpuTime = operatingSystemMXBean.getProcessCpuTime();
        // code to be measured
        long finalCpuTime = operatingSystemMXBean.getProcessCpuTime();
        long cpuTimeUsed = finalCpuTime - initialCpuTime;
        System.out.println("CPU time used: " + cpuTimeUsed);
    }
}