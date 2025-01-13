/*
 * Decompiled with CFR 0.152.
 */
public class ThreadCreator {
    public static void main(String[] stringArray) {
        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
            }
        });
        thread.setName("MyThread");
        thread.start();
    }
}
