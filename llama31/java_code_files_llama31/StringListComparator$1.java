/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import java.util.List;

static class StringListComparator.1
implements Comparator<List<String>> {
    StringListComparator.1() {
    }

    @Override
    public int compare(List<String> list, List<String> list2) {
        return list.get(1).compareTo(list2.get(1));
    }
}
