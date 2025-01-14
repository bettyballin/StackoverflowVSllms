import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileWriterWithFlush {
    public static void main(String[] args) throws IOException {
        String filename = "output.txt";
        FileOutputStream s = new FileOutputStream(filename);
        FileChannel c = s.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        boolean xyz = true; // Placeholder condition
        while (xyz) {
            c.write(buffer);
            // Update xyz condition to exit loop as needed
            xyz = false; // Prevent infinite loop for this example
        }
        c.force(true);  // Flushes changes out to the OS and forces them to disk
        s.getFD().sync();  // Sync to hardware device
        c.close();
    }
}