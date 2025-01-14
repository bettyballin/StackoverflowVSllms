import java.lang.String;
import java.io.*;

public class FileWriterUtil {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("file.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write("Hello, World!".getBytes());
            // Explicitly flush the stream to ensure all data is written to the underlying file system.
            bos.flush();
            // Sync to force a disk write
            FileDescriptor fd = fos.getFD();
            fd.sync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}