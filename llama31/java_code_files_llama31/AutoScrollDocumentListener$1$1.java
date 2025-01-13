/*
 * Decompiled with CFR 0.152.
 */
class AutoScrollDocumentListener.1
implements Runnable {
    AutoScrollDocumentListener.1() {
    }

    @Override
    public void run() {
        this$0.scroll.getVerticalScrollBar().setValue(0);
    }
}
