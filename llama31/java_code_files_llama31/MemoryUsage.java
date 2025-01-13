/*
 * Decompiled with CFR 0.152.
 */
public class MemoryUsage {
    public static void main(String[] stringArray) {
        Runtime runtime = Runtime.getRuntime();
        long l = runtime.totalMemory();
        long l2 = runtime.freeMemory();
        long l3 = l - l2;
        System.out.println("Total Memory: " + MemoryUsage.humanReadableByteCount(l));
        System.out.println("Free Memory: " + MemoryUsage.humanReadableByteCount(l2));
        System.out.println("Used Memory: " + MemoryUsage.humanReadableByteCount(l3));
    }

    public static String humanReadableByteCount(long l) {
        int n = 1024;
        if (l < (long)n) {
            return l + " bytes";
        }
        int n2 = (int)(Math.log(l) / Math.log(n));
        String string = String.valueOf("kMGTPE".charAt(n2 - 1));
        return String.format("%.1f %sB", (double)l / Math.pow(n, n2), string);
    }
}
