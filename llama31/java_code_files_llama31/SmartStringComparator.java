/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

class SmartStringComparator
implements Comparator<String> {
    SmartStringComparator() {
    }

    @Override
    public int compare(String string, String string2) {
        return string.compareTo(string2);
    }
}
