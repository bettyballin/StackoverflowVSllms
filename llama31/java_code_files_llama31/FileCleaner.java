/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class FileCleaner {
    public static void main(String[] stringArray) {
        File file = new File("tmp_file.txt");
        file.deleteOnExit();
    }
}
