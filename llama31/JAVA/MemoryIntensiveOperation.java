import java.util.List;
import java.util.ArrayList;

class Data {
    // Define the Data class to avoid compilation errors
}

public class MemoryIntensiveOperation {
    private List<Data> data; // Declare the 'data' variable

    public void performOperation() {
        // Assume 'data' is a large dataset that doesn't fit into memory
        for (int i = 0; i < data.size(); i += CHUNK_SIZE) {
            processChunk(data.subList(i, Math.min(i + CHUNK_SIZE, data.size())));
        }
    }

    private void processChunk(List<Data> chunk) {
        // Process a chunk of data
    }

    private static final int CHUNK_SIZE = 1000; // Adjust based on memory constraints

    public static void main(String[] args) {
        // Create an instance of MemoryIntensiveOperation to avoid compilation warnings
        MemoryIntensiveOperation operation = new MemoryIntensiveOperation();
        operation.data = new ArrayList<>(); // Initialize the 'data' variable
        operation.performOperation();
    }
}