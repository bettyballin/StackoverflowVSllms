/*
 * Decompiled with CFR 0.152.
 */
static class Main_281.1
extends Thread {
    final /* synthetic */ Process val$p;

    Main_281.1(Process process) {
        this.val$p = process;
    }

    @Override
    public void run() {
        this.val$p.destroy();
    }
}
