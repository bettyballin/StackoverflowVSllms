import java.lang.String;
public class MemoryUsage {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.println("Total Memory: " + humanReadableByteCount(totalMemory));
        System.out.println("Free Memory: " + humanReadableByteCount(freeMemory));
        System.out.println("Used Memory: " + humanReadableByteCount(usedMemory));
    }

    public static String humanReadableByteCount(long bytes) {
        int unit = 1024;
        if (bytes < unit) return bytes + " bytes";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = String.valueOf("kMGTPE".charAt(exp-1));
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }
}