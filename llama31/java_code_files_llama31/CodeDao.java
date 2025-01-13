/*
 * Decompiled with CFR 0.152.
 */
class CodeDao {
    private int latestCodeNumber = 0;

    CodeDao() {
    }

    public int getLatestCodeNumber() {
        return this.latestCodeNumber;
    }

    public void updateCodeNumber(int n) {
        this.latestCodeNumber = n;
    }
}
