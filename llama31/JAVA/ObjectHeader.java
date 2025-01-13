public class ObjectHeader {
    // 4 bytes on 32-bit, 8 bytes on 64-bit
    private long markWord;

    // 4 bytes on 32-bit, 8 bytes on 64-bit
    private long klass;

    // Optional fields, e.g., for arrays or synchronization
}