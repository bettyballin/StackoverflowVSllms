/*
 * Decompiled with CFR 0.152.
 */
public class DatabaseOperationRetryHandler {
    @Retry(value=3)
    public void performDatabaseOperation() {
    }

    public static void main(String[] stringArray) {
    }
}
