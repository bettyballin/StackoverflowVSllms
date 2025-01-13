/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;

public class HeapDumpAnalyzer {
    public static void main(String[] stringArray) {
        File file = new File("heapdump.hprof");
        HeapDump heapDump = new HeapDump(file);
        ObjectSet objectSet = heapDump.getObjectSet();
        for (Object object : objectSet) {
            System.out.println(object.toString());
        }
    }
}
