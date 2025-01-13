/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class Main_64 {
    public static void main(String[] stringArray) {
        File file = new File("source.txt");
        File file2 = new File("dest.txt");
        if (Main_64.canMoveOrCopy(file, file2)) {
            System.out.println("The file can be moved or copied.");
        } else {
            System.out.println("The file cannot be moved or copied.");
        }
    }

    public static boolean canMoveOrCopy(File file, File file2) {
        if (!file.exists() || !file.canRead()) {
            return false;
        }
        if (file2.exists() && !file2.canWrite()) {
            return false;
        }
        File file3 = file2.getParentFile();
        return file3 == null || file3.canWrite();
    }
}
