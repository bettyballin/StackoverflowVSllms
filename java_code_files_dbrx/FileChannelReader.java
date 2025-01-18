import java.lang.String;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.channels.Channels;

public class FileChannelReader {

    public static void main(String[] args) {
        Path file = Paths.get("path", "to", "your", "file");
        try (RandomAccessFile raf = new RandomAccessFile(file.toString(), "rw")) {
            FileChannel ch = raf.getChannel();
            while(ch.tryLock() == null) {
                // wait or handle accordingly
                Thread.sleep(50);
            }
            try (WritableByteChannel outChan = Channels.newChannel(System.out)) {
                ch.transferTo(0, ch.size(), outChan);
            } finally  {
               // always make sure to release the lock
               ch.close();
            }
        } catch (Exception e) {
           System.err.println("Error: " + e.getMessage());
        }
    }
}