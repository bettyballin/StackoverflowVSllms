import java.lang.String;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

public class Monitor {

    private String FindLatestFile(String folderPath) {
        FilenameFilter filter = new LogFileFilter();

        File dir = new File(folderPath);

        File[] files = dir.listFiles(filter);

        if (files != null && files.length > 0) {
            Arrays.sort(files, new LastModifiedComparator());

            return files[files.length - 1].toString();
        } else {
            return "";
        }
    }

    private class LogFileFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".log") && name.contains("CJL");
        }
    }

    private class LastModifiedComparator implements Comparator<File> {
        @Override
        public int compare(File f1, File f2) {
            return Long.valueOf(f1.lastModified()).compareTo(Long.valueOf(f2.lastModified()));
        }
    }

    // main method or other logic to test FindLatestFile

	public static void main(String[] args) {
	}
}