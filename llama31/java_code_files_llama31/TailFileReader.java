/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

public class TailFileReader
extends Reader {
    private static final int SLEEP_TIME = 1000;
    private final File file;
    private RandomAccessFile raf;
    private final byte[] buffer = new byte[1024];
    private int bufferPosition;
    private int bufferLength;

    public TailFileReader(String string) throws FileNotFoundException {
        this.file = new File(string);
        this.raf = new RandomAccessFile(this.file, "r");
    }

    @Override
    public int read(char[] cArray, int n, int n2) throws IOException {
        if (this.bufferLength == -1) {
            return -1;
        }
        if (this.bufferPosition == this.bufferLength) {
            this.bufferLength = this.raf.read(this.buffer);
            this.bufferPosition = 0;
            if (this.bufferLength == -1) {
                while (this.bufferLength == -1) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000L);
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    if (this.file.lastModified() <= this.raf.length()) continue;
                    this.raf.seek(this.raf.length());
                    this.bufferLength = this.raf.read(this.buffer);
                }
                this.bufferPosition = 0;
            }
        }
        int n3 = 0;
        while (this.bufferPosition < this.bufferLength && n3 < n2) {
            cArray[n + n3++] = (char)this.buffer[this.bufferPosition++];
        }
        return n3;
    }

    @Override
    public void close() throws IOException {
        this.raf.close();
    }

    public static void main(String[] stringArray) throws IOException {
        String string;
        TailFileReader tailFileReader = new TailFileReader("application.log");
        BufferedReader bufferedReader = new BufferedReader(tailFileReader);
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
    }
}
