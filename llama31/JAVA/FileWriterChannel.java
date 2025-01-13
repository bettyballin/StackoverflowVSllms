import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.ByteBuffer;

public class FileWriterChannel {
    public static void main(String[] args) {
        String filename = "example.txt"; // specify a filename
        boolean xyz = true; // specify a condition for the while loop
        ByteBuffer buffer = ByteBuffer.allocate(1024); // specify a buffer

        try (FileOutputStream s = new FileOutputStream(filename)) {
            Channel c = s.getChannel();
            while (xyz) {
                c.write(buffer);
                // you may want to modify the buffer or the condition here
                xyz = false; // to avoid an infinite loop
            }
            c.force(true); // Forces any updates to this channel's file to be written to the storage device
            s.getFD().sync(); // Force all system buffers to synchronize with the underlying device
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}