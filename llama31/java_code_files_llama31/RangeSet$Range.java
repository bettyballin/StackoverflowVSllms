/*
 * Decompiled with CFR 0.152.
 */
private static class RangeSet.Range {
    int start;
    int end;

    RangeSet.Range(int n, int n2) {
        this.start = n;
        this.end = n2;
    }

    boolean intersects(RangeSet.Range range) {
        return this.start <= range.end && range.start <= this.end;
    }
}
