/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class FileReadingTask
implements Runnable {
    private File file;
    private long offset;
    private long chunkEnd;

    public FileReadingTask(File file, long l, long l2) {
        this.file = file;
        this.offset = l;
        this.chunkEnd = l2;
    }

    @Override
    public void run() {
        try (FileInputStream fileInputStream = new FileInputStream(this.file);){
            fileInputStream.skip(this.offset);
            byte[] byArray = new byte[(int)(this.chunkEnd - this.offset)];
            fileInputStream.read(byArray);
            System.out.println("Read chunk from " + this.offset + " to " + this.chunkEnd);
        }
        catch (IOException iOException) {
            Thread.currentThread().interrupt();
        }
    }
}
