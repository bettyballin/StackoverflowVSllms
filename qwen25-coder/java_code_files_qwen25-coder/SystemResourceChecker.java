import java.lang.String;
public class SystemResourceChecker {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Max Memory: " + bytesToMegabytes(maxMemory) + " MB");

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available Processors: " + availableProcessors);
    }

    private static long bytesToMegabytes(long bytes) {
        return bytes / (1024 * 1024);
    }
}