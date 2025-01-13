/*
 * Decompiled with CFR 0.152.
 */
private class RangeSet.Node {
    RangeSet.Range range;
    int min;
    int max;
    RangeSet.Node left;
    RangeSet.Node right;

    RangeSet.Node(RangeSet rangeSet, RangeSet.Range range) {
        this.range = range;
        this.min = range.start;
        this.max = range.end;
    }
}
