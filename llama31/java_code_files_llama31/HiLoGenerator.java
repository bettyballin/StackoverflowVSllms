/*
 * Decompiled with CFR 0.152.
 */
public class HiLoGenerator {
    private long hiValue;
    private int loValue = 1;

    public synchronized long nextId() {
        long l = (this.hiValue << 16) + (long)this.loValue;
        ++this.loValue;
        return l;
    }

    public void updateHiValue(long l) {
        this.hiValue = l;
    }

    public static void main(String[] stringArray) {
    }
}
