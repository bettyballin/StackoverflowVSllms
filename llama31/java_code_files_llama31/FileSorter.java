/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.util.Arrays;

public class FileSorter {
    public static void main(String[] stringArray) {
        File file3 = new File(".");
        File[] fileArray = file3.listFiles();
        if (fileArray != null) {
            Arrays.sort(fileArray, (file, file2) -> Long.compare(file.lastModified(), file2.lastModified()));
        }
    }
}
