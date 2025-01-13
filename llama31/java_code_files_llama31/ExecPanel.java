/*
 * Decompiled with CFR 0.152.
 */
class ExecPanel {
    private boolean reset = false;

    ExecPanel() {
    }

    public boolean isReset() {
        return this.reset;
    }

    public void unreset() {
        this.reset = false;
    }

    public void setReset() {
        this.reset = true;
    }
}
