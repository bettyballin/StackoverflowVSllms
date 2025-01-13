/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MultithreadedFileCopy {
    public static void copyFile(String string, String string2, int n) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(string);
        FileOutputStream fileOutputStream = new FileOutputStream(string2);
        long l = fileInputStream.getChannel().size();
        long l2 = l / (long)n;
        Thread[] threadArray = new Thread[n];
        for (int i = 0; i < n; ++i) {
            long l3 = (long)i * l2;
            long l4 = i == n - 1 ? l : (long)(i + 1) * l2;
            threadArray[i] = new CopyThread(fileInputStream, fileOutputStream, l3, l4);
            threadArray[i].start();
        }
        for (Thread thread : threadArray) {
            try {
                thread.join();
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void main(String[] stringArray) {
        try {
            MultithreadedFileCopy.copyFile("source.txt", "target.txt", 4);
        }
        catch (IOException iOException) {
            System.err.println("Error copying file: " + iOException.getMessage());
        }
    }

    private static class CopyThread
    extends Thread {
        private FileInputStream srcFile;
        private FileOutputStream tgtFile;
        private long start;
        private long end;

        public CopyThread(FileInputStream fileInputStream, FileOutputStream fileOutputStream, long l, long l2) {
            this.srcFile = fileInputStream;
            this.tgtFile = fileOutputStream;
            this.start = l;
            this.end = l2;
        }

        @Override
        public void run() {
            try {
                int n;
                this.srcFile.getChannel().position(this.start);
                byte[] byArray = new byte[4096];
                while (this.start < this.end && (n = this.srcFile.read(byArray)) != -1) {
                    this.tgtFile.write(byArray, 0, n);
                    this.start += (long)n;
                }
            }
            catch (IOException iOException) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
