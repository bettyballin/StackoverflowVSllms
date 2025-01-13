import java.nio.ByteBuffer;

// Abstraction inversion example
public abstract class MemoryBlock extends ByteBuffer {
    // Implement any necessary methods or keep it abstract
}

public class MemoryManager {
    public MemoryBlock allocate(int size) {
        // Since MemoryBlock is abstract, we can't directly instantiate it.
        // For demonstration purposes, return null or implement a concrete subclass of MemoryBlock.
        return null;
    }

    public static void main(String[] args) {
        MemoryManager manager = new MemoryManager();
        manager.allocate(10);
    }
}