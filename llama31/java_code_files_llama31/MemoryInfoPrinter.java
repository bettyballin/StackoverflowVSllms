/*
 * Decompiled with CFR 0.152.
 */
public class MemoryInfoPrinter {
    public static void main(String[] stringArray) {
        System.out.println("Max memory: " + Runtime.getRuntime().maxMemory());
        System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());
    }
}
