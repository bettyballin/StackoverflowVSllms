/*
 * Decompiled with CFR 0.152.
 */
class Period {
    private long start;
    private long end;

    public Period(long l, long l2) {
        this.start = l;
        this.end = l2;
    }

    public long getStart() {
        return this.start;
    }

    public long getEnd() {
        return this.end;
    }

    public boolean intersects(Period period) {
        return this.start <= period.end && this.end >= period.start;
    }
}
