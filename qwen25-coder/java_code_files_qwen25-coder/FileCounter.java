import java.lang.String;
import java.io.File;

public class FileCounter {
    public static int countFiles(String directoryPath, int maxCount) {
        File dir = new File(directoryPath);
        if (!dir.isDirectory()) return -1; // Return -1 or throw an exception if it's not a directory

        String[] files = dir.list();
        if (files == null || files.length == 0) return 0;

        for (int i = 0; i < files.length; i++) {
            if (i >= maxCount) {
                return maxCount;
            }
        }
        return files.length;
    }

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        int maxCount = 5000;
        int fileCount = countFiles(directoryPath, maxCount);
        
        if (fileCount >= maxCount) {
            System.out.println("Directory contains " + maxCount + " or more files.");
        } else {
            System.out.println("Directory contains " + fileCount + " files.");
        }
    }
}