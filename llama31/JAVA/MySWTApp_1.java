import java.lang.foreign.*;
import java.lang.invoke.MethodHandles;

public class MySWTApp_1_1 {
    public static void main(String[] args) {
        MemorySegment segment = MemorySegment.allocateNative(1024);
        // Use the segment to access native memory...
    }
}