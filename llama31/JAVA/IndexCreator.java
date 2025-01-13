import java.io.File;
import java.io.RandomAccessFile;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IndexCreator {
    public static void main(String[] args) throws IOException {
        // Load the text file
        File file = new File("example.txt");
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            // Create a hash table to store the index
            Map<String, Long> index = new HashMap<>();

            // Read the file and build the index
            long offset = 0;
            String line;
            while ((line = raf.readLine()) != null) {
                String[] parts = line.split(",");
                String key = parts[0].trim();
                index.put(key, offset);
                offset = raf.getFilePointer();
            }

            // Write the index to a file
            File indexFile = new File("index.txt");
            try (FileWriter writer = new FileWriter(indexFile)) {
                for (Map.Entry<String, Long> entry : index.entrySet()) {
                    writer.write(entry.getKey() + " " + Long.toHexString(entry.getValue()) + "\n");
                }
            }
        }
    }
}