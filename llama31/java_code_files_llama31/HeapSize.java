/*
 * Decompiled with CFR 0.152.
 */
public class HeapSize {
    public static void main(String[] stringArray) {
        long l = Runtime.getRuntime().totalMemory();
        System.out.println("Current heap size: " + l);
    }
}
