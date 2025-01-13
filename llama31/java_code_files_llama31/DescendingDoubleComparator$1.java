/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

static class DescendingDoubleComparator.1
implements Comparator<Double> {
    DescendingDoubleComparator.1() {
    }

    @Override
    public int compare(Double d, Double d2) {
        return d2.compareTo(d);
    }
}
