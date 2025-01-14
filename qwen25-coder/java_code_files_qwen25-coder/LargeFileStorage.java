import java.lang.String;
import java.util.Map;
import java.util.HashMap;
// Example pseudo-code demonstrating simple indexed access into a large file
import java.nio.file.*;
import java.io.*;

class DataBlock {
    long offset;
    int size;

    DataBlock(long offset, int size) {
        this.offset = offset;
        this.size = size;
    }
}

public class LargeFileStorage {
    private Path filePath;
    private RandomAccessFile dataFile;
    private Map<String, DataBlock> index; // Index key to DataBlock mapping

    public LargeFileStorage(String path) throws IOException {
        filePath = Paths.get(path);
        dataFile = new RandomAccessFile(filePath.toFile(), "r");
        loadIndex(); // This function needs to be implemented to read or build the index
    }

    private void loadIndex() {
        index = new HashMap<>();
        // Load or build your index here
    }

    public byte[] readData(String key) throws IOException {
        DataBlock block = index.get(key);
        if (block == null) return null;
        dataFile.seek(block.offset); // Go to the right offset in the file
        byte[] data = new byte[block.size];
        dataFile.readFully(data);
        return data;
    }

    public void close() throws IOException {
        dataFile.close();
    }

    public static void main(String[] args) {
    }
}