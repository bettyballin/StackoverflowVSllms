/*
 * Decompiled with CFR 0.152.
 */
class SynchronizedAccessor.2
implements Runnable {
    SynchronizedAccessor.2() {
    }

    @Override
    public void run() {
        SynchronizedAccessor.this.sharedInstance.getInstanceVar();
    }
}
