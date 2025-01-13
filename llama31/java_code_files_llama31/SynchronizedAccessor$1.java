/*
 * Decompiled with CFR 0.152.
 */
class SynchronizedAccessor.1
implements Runnable {
    SynchronizedAccessor.1() {
    }

    @Override
    public void run() {
        SynchronizedAccessor.this.sharedInstance.setInstanceVar();
    }
}
