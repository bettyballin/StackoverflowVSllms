import java.lang.String;
import java.util.Arrays;

public class Main_620 {
    public static void main(String[] args) {
        String[] fileNames = {"file1.txt", "file2.pdf", "file3.mp3", "file4.txt", "file5.pdf"};

        Arrays.sort(fileNames, (f1, f2) -> {
            String ext1 = getFileExtension(f1);
            String ext2 = getFileExtension(f2);
            return ext1.compareTo(ext2);
        });

        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    private static String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex > 0) {
            return fileName.substring(lastIndex + 1);
        } else {
            return "";
        }
    }
}