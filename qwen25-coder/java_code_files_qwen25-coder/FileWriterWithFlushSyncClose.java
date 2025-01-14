import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriterWithFlushSyncClose {

    private String filename;
    private boolean xyz;
    private byte[] buffer;

    public FileWriterWithFlushSyncClose() {
        try {
            FileOutputStream s = new FileOutputStream(filename);
            while (xyz) {
                s.write(buffer);
            }
            s.flush();  // Flushes changes out to the OS
            s.getFD().sync();  // Sync to hardware device
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}