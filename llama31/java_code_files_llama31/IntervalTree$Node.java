/*
 * Decompiled with CFR 0.152.
 */
private static class IntervalTree.Node {
    Period interval;
    long midpoint;
    IntervalTree.Node left;
    IntervalTree.Node right;

    IntervalTree.Node(Period period) {
        this.interval = period;
        this.midpoint = (period.getStart() + period.getEnd()) / 2L;
    }
}
