/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.RandomAccessFile;

public class FilePoller {
    public static void main(String[] stringArray) throws IOException {
        String string = "/path/to/your/file.csv";
        long l = 0L;
        while (true) {
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(string, "r");){
                long l2 = randomAccessFile.length();
                if (l2 > l) {
                    int n;
                    randomAccessFile.seek(l);
                    byte[] byArray = new byte[1024];
                    while ((n = randomAccessFile.read(byArray)) != -1) {
                    }
                    l = l2;
                }
            }
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
