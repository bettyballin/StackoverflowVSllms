import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.OSFileStore;

public class SystemMonitor {
    public static void main(String[] args) {
        // Create a new SystemInfo object
        SystemInfo si = new SystemInfo();

        // Get hardware abstraction layer
        HardwareAbstractionLayer hal = si.getHardware();

        // CPU Usage
        CentralProcessor processor = hal.getProcessor();
        double cpuUsage = processor.getSystemLoadAverage(1);

        // Memory Usage
        GlobalMemory memory = hal.getMemory();
        long totalMemory = memory.getTotal();
        long freeMemory = memory.getAvailable();

        // Disk Usage
        OSFileStore[] partitions = si.getOperatingSystem().getFileSystem().getFileStores();

        System.out.println("CPU usage: " + cpuUsage * 100 + "%");
        System.out.println("Total Memory: " + (totalMemory / (1024L * 1024)) + " MB");
        System.out.println("Free Memory: " + (freeMemory / (1024L * 1024)) + " MB");

        for (OSFileStore partition : partitions) {
            System.out.printf("%s (total=%d GB; usable=%d GB)\n", partition.getMount(),
                    partition.getTotalSpace() / (1024L * 1024 * 1024),
                    partition.getUsableSpace() / (1024L * 1024 * 1024));
        }
    }
}