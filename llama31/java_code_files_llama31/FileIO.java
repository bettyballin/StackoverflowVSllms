/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIO {
    public static void main(String[] stringArray) throws IOException {
        File file = new File("path/to/file");
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read();
        fileInputStream.close();
    }
}
