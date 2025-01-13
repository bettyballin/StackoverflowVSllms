/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

static class CaseSensitiveStringComparator.1
implements Comparator<String> {
    CaseSensitiveStringComparator.1() {
    }

    @Override
    public int compare(String string, String string2) {
        char c;
        char c2 = string.charAt(0);
        if (c2 < (c = string2.charAt(0))) {
            return -1;
        }
        if (c2 > c) {
            return 1;
        }
        return string.compareTo(string2);
    }
}
