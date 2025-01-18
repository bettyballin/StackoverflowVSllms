import java.io.RandomAccessFile;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        RandomAccessFile raf = new RandomAccessFile(path, "rw");
        // Passing this handle to other process...
        raf.close(); // Closing or flushing the file handle post use in parent process (A)..
    }
}