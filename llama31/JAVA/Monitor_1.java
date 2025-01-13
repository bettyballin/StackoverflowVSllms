import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

public class Monitor_1_1 {
    private static class LogFileFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".log") && name.contains("CJL");
        }
    }

    private static class LogFileComparator implements Comparator<File> {
        @Override
        public int compare(File f1, File f2) {
            return Long.compare(f1.lastModified(), f2.lastModified());
        }
    }

    private String findLatestFile(String folderPath) {
        File dir = new File(folderPath);
        File[] files = dir.listFiles(new LogFileFilter());

        if (files != null && files.length > 0) {
            Arrays.sort(files, new LogFileComparator());
            File newest = files[files.length - 1];
            return newest.toString();
        } else {
            return "";
        }
    }

	public static void main(String[] args) {
		Monitor_1 monitor = new Monitor_1();
		String latestFile = monitor.findLatestFile("/path/to/folder");
		System.out.println("Latest file: " + latestFile);
	}
}