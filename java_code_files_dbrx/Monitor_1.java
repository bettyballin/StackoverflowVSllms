import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Monitor {
    private static com.sun.management.OperatingSystemMXBean sunOsMbean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    private long startTime; // for time measurement
    private double startCpuLoad, endCpuLoad; // for cpu usage calculation
    private Runtime runtimeObj;

    public Monitor() {
        this.runtimeObj = Runtime.getRuntime();

        // Get CPU load before code execution to calculate difference later
        this.startCpuLoad = sunOsMbean.getProcessCpuLoad();
    }

    public void start() {
        System.out.println("Monitoring Started");

        // Take note of current time for calculation after stopping monitor
        this.startTime = System.currentTimeMillis();

        printCountersBeforeExecution();
    }

    public void stop() {
        System.out.println("Monitoring Stopped");

        long endTime = System.currentTimeMillis(); // get the current time when stopped monitor

        this.endCpuLoad = sunOsMbean.getProcessCpuLoad(); // get cpu load after execution to calculate difference later

        printExecutionMetrics(this.startTime, endTime);
    }

    private void printCountersBeforeExecution() {
        System.out.println("Free memory before: " + this.runtimeObj.freeMemory());

        System.out.println("Max Memory :"     + this.runtimeObj.maxMemory());

        System.out.println("Total memory available to JVM:"     + this.runtimeObj.totalMemory() );
    }

    private void printExecutionMetrics(long startTime, long endTime) {
        // calculate execution time in seconds
        double duration = (endTime - this.startTime)/1000;

        System.out.println("Execution Time: " + duration +" sec");

        // Calculate total and used memory
        long freeMemoryAfter = runtimeObj.freeMemory();
        double totalMemory = runtimeObj.totalMemory() /1024/1024;
        double usedMemory = (runtimeObj.totalMemory() - runtimeObj.freeMemory()) / 1024/1024 ;
        double maxMemory = runtimeObj.maxMemory();
        System.out.println("Total Memory:" + totalMemory+ "MB");
        System.out.println("Used Memory :"+ usedMemory+" MB");
        System.out.println ("Free memory after execution : "+ runtimeObj.freeMemory());
        long maxM = runtimeObj.maxMemory();
        String strMax = Long.toString(maxM);
        System.out.println("Maximum possible heap size is " + (strMax)+" bytes.");
        // Calculate total memory used by Java VM using JMX OperatingSystemMXBean
        long mxTotalMem = sunOsMbean.getTotalPhysicalMemorySize();
        double jvmUsed = ((sunOsMbean.getTotalPhysicalMemorySize() - sunOsMbean.getFreePhysicalMemorySize()) / 1024/1024);
        System.out.println("JVM used memory"+ jvmUsed );

        // calculate CPU usage by subtracting cpu load before execution from after execution
        double cpuUsage = (this.endCpuLoad - this.startCpuLoad) / duration;
        System.out.printf("%.2f%% ", Double.valueOf(cpuUsage));
    }

    public static void main(String[] args) {
    }
}