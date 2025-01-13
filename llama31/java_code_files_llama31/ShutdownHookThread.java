/*
 * Decompiled with CFR 0.152.
 */
public class ShutdownHookThread {
    public static void main(String[] stringArray) {
        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {
            }
        });
    }
}
