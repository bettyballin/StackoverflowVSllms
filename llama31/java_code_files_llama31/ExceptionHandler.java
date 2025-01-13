/*
 * Decompiled with CFR 0.152.
 */
public class ExceptionHandler {
    public static void main(String[] stringArray) {
    }

    static {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){

            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
            }
        });
    }
}
