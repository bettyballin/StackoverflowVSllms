/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class DiskCrawler {
    public static void main(String[] stringArray) {
        File[] fileArray;
        for (File file : fileArray = File.listRoots()) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
