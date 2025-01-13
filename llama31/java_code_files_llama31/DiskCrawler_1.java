/*
 * Decompiled with CFR 0.152.
 */
import java.nio.file.FileSystems;

public class DiskCrawler_1 {
    public static void main(String[] stringArray) {
        FileSystems.getDefault().getFileStores().forEach(fileStore -> System.out.println(fileStore.toString()));
    }
}
