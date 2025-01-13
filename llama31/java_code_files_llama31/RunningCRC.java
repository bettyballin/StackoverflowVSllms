/*
 * Decompiled with CFR 0.152.
 */
import java.util.zip.CRC32;

public class RunningCRC {
    public static int computeCRC32(byte[] byArray, int n) {
        CRC32 cRC32 = new CRC32();
        cRC32.update(byArray);
        return (int)cRC32.getValue() ^ n;
    }

    public static void main(String[] stringArray) {
        int n = 0;
        n = RunningCRC.computeCRC32("abcdef".getBytes(), n);
        n = RunningCRC.computeCRC32("ghijkl".getBytes(), n);
        System.out.println(n);
    }
}
