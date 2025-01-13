/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main_600 {
    public static void main(String[] stringArray) throws IOException {
        File file = new File("path/to/your/file");
        long l = file.length();
        int n = 0x100000;
        long l2 = 5 * n;
        long l3 = l2 + (long)n;
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.skip(l2);
        byte[] byArray = new byte[(int)(l3 - l2)];
        fileInputStream.read(byArray);
        fileInputStream.close();
    }
}
