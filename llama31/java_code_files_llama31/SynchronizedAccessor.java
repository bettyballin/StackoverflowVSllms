/*
 * Decompiled with CFR 0.152.
 */
public class SynchronizedAccessor {
    MyClass sharedInstance = new MyClass();

    public void test() throws InterruptedException {
        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                SynchronizedAccessor.this.sharedInstance.setInstanceVar();
            }
        });
        Thread thread2 = new Thread(new Runnable(){

            @Override
            public void run() {
                SynchronizedAccessor.this.sharedInstance.getInstanceVar();
            }
        });
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
    }

    public static void main(String[] stringArray) throws InterruptedException {
        SynchronizedAccessor synchronizedAccessor = new SynchronizedAccessor();
        synchronizedAccessor.test();
    }
}
