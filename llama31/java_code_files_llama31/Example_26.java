/*
 * Decompiled with CFR 0.152.
 */
public class Example_26 {
    public static void main(String[] stringArray) {
        while (true) {
            Example_26.myMethod();
        }
    }

    public static void myMethod() {
        try {
            Thread.sleep(1000L);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
