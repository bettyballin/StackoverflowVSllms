/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class MemoryLeakExample {
    private static List<byte[]> list = new ArrayList<byte[]>();

    public static void main(String[] stringArray) {
        while (true) {
            list.add(new byte[0x100000]);
            try {
                Thread.sleep(1000L);
                continue;
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                continue;
            }
            break;
        }
    }
}
