/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class FileMetaDataAccessor {
    public static void main(String[] stringArray) {
        File file = new File("path/to/file");
        long l = file.lastModified();
    }
}
