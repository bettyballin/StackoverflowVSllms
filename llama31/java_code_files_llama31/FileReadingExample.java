/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReadingExample {
    public static void main(String[] stringArray) throws IOException, InterruptedException {
        File file = new File("path_to_your_file.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            byte[] byArray;
            int n;
            if ((n = fileInputStream.read(byArray = new byte[1024])) == -1) {
                Thread.sleep(100L);
                continue;
            }
            String string = new String(byArray, 0, n);
            System.out.println(string);
        }
    }
}
