/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SyncExample {
    public static void main(String[] stringArray) throws IOException {
        File file = new File("example.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);){
            fileOutputStream.getFD().sync();
        }
    }
}
