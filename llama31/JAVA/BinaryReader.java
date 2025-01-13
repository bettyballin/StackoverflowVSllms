import java.lang.String;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryReader {
    public static void main(String[] args) throws IOException {
        try (DataInputStream in = new DataInputStream(new FileInputStream("example.bin"))) {
            int version = in.readInt();
            byte type = in.readByte();
            int beginOfData = in.readInt();
            byte[] id = new byte[16];
            in.readFully(id);

            // Read records
            while (in.available() > 0) {
                int recordLength = in.readInt();
                byte[] recordData = new byte[recordLength];
                in.readFully(recordData);
                // Process record data
            }
        }
    }
}