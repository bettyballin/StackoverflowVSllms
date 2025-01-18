import java.lang.String;
import java.lang.*; // or simply import java.* for everything under 'java' hierarchy
import java.io.File;

public class Main_224 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();  // Returns the runtime object associated with the current Java application.

        long totalMemory = runtime.totalMemory();   // Returns the total amount of memory in the Java virtual machine.
        long maxMemory = runtime.maxMemory();            // Returns the maximum amount of memory that the Java virtual machine will attempt to use.
        long freeMemory = runtime.freeMemory();          // Returns the amount of free memory in the Java Virtual Machine.
        // Compute % usage: 100 * (total - free) / total

        File fileSystem = new File("/");            // Use root directory or any other specific path for disk usage statistics. This is for Unix based systems, change it to C:\ in Windows.
        long totalSpace = fileSystem.getTotalSpace();    // Returns the size of the partition.
        long freeSpace = fileSystem.getFreeSpace();      // Returns the space available on this file system in bytes.
    }
}