/*
 * Decompiled with CFR 0.152.
 */
static class NestingAlgorithm.Cut {
    int length;
    int quantity;

    public NestingAlgorithm.Cut(int n, int n2) {
        this.length = n;
        this.quantity = n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        NestingAlgorithm.Cut cut = (NestingAlgorithm.Cut)object;
        return this.length == cut.length && this.quantity == cut.quantity;
    }
}
