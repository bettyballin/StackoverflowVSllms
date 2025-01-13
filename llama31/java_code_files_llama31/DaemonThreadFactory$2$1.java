/*
 * Decompiled with CFR 0.152.
 */
class DaemonThreadFactory.1
extends Thread {
    final /* synthetic */ Process val$process;

    DaemonThreadFactory.1(DaemonThreadFactory.2 var1_1, Process process) {
        this.val$process = process;
    }

    @Override
    public void run() {
        this.val$process.destroy();
    }
}
