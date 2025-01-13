/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

static class MyComparator.MyComparatorInner
implements Comparator<String> {
    MyComparator.MyComparatorInner() {
    }

    @Override
    public int compare(String string, String string2) {
        return string.toUpperCase().compareTo(string2.toUpperCase());
    }
}
