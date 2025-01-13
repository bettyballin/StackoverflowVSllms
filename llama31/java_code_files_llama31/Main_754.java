/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.util.Arrays;

public class Main_754 {
    public static void main(String[] stringArray) {
        File file3 = new File("/path/to/your/directory");
        File[] fileArray = file3.listFiles();
        if (fileArray != null) {
            File[] fileArray2;
            for (File file4 : fileArray2 = (File[])Arrays.stream(fileArray).sorted((file, file2) -> Long.compare(file.lastModified(), file2.lastModified())).toArray(File[]::new)) {
                System.out.println(file4.getName());
            }
        } else {
            System.out.println("Directory not found or is empty.");
        }
    }
}
