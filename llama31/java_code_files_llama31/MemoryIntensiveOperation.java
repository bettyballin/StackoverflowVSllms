/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class MemoryIntensiveOperation {
    private List<Data> data;
    private static final int CHUNK_SIZE = 1000;

    public void performOperation() {
        for (int i = 0; i < this.data.size(); i += 1000) {
            this.processChunk(this.data.subList(i, Math.min(i + 1000, this.data.size())));
        }
    }

    private void processChunk(List<Data> list) {
    }

    public static void main(String[] stringArray) {
        MemoryIntensiveOperation memoryIntensiveOperation = new MemoryIntensiveOperation();
        memoryIntensiveOperation.data = new ArrayList<Data>();
        memoryIntensiveOperation.performOperation();
    }
}
