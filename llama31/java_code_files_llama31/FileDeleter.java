/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class FileDeleter {
    public static void deleteFiles(String string, String string2) {
        File[] fileArray;
        File file = new File(string);
        for (File file2 : fileArray = file.listFiles()) {
            if (!file2.isFile() || !file2.getName().endsWith(string2)) continue;
            try {
                if (file2.delete()) {
                    System.out.println("Deleted file: " + file2.getName());
                    continue;
                }
                System.out.println("Failed to delete file: " + file2.getName());
            }
            catch (SecurityException securityException) {
                System.out.println("Security exception occurred while deleting file: " + file2.getName());
            }
        }
    }

    public static void main(String[] stringArray) {
        FileDeleter.deleteFiles("/path/to/directory", ".gif");
    }
}
