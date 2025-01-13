/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

private static class MultithreadedFileCopy.CopyThread
extends Thread {
    private FileInputStream srcFile;
    private FileOutputStream tgtFile;
    private long start;
    private long end;

    public MultithreadedFileCopy.CopyThread(FileInputStream fileInputStream, FileOutputStream fileOutputStream, long l, long l2) {
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
