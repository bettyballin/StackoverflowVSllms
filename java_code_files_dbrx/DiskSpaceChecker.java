import java.io.File;

public class DiskSpaceChecker {
    public double getFreeSpacePercentage(String path) {
        File directory = new File(path);

        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid or non-existing MMC root directory.");
        }

        long totalSizeBytes = directory.getTotalSpace(); // In bytes
        long freeSpaceBytes = directory.getUsableSpace(); // In bytes, excluding reserved file system space for other users' temporary files (if applicable)

        double freeSpacePercentage = ((double) freeSpaceBytes / totalSizeBytes) * 100;
        return Math.round(freeSpacePercentage * 100.0) / 100.0; // Round to two decimal places and return the result.
    }
}