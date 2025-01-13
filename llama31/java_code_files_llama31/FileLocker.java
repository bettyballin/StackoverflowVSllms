/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;

public class FileLocker {
    public static void main(String[] stringArray) {
        File file = new File("path/to/lockfile.lock");
        try {
            if (!file.createNewFile()) {
                System.out.println("Lock file already exists, aborting...");
                return;
            }
        }
        catch (IOException iOException) {
            System.err.println("Error creating lock file: " + iOException.getMessage());
            return;
        }
        File file2 = new File("path/to/mainfile.txt");
        if (!file.delete()) {
            System.err.println("Error deleting lock file");
        }
    }
}
