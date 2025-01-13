/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileStreamUtil {
    public static void main(String[] stringArray) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("path_to_your_file");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 0x100000);
    }
}
