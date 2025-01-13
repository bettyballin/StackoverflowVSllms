/*
 * Decompiled with CFR 0.152.
 */
public class FaultHandler {
    public static void main(String[] stringArray) {
        FaultBarrier.handleFault(() -> {
            throw new Exception("Test exception");
        });
    }
}
