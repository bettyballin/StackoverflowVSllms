/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class FileManager {
    public void deleteFile(String string) {
        File file = new File(string);
        if (file.exists()) {
            file.delete();
        }
    }

    public void renameFile(String string, String string2) {
        File file = new File(string);
        File file2 = new File(string2);
        if (file.exists()) {
            file.renameTo(file2);
        }
    }

    public static void main(String[] stringArray) {
    }
}
