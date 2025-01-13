/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

public class MyComparator {
    public static void main(String[] stringArray) {
    }

    static class MyComparatorInner
    implements Comparator<String> {
        MyComparatorInner() {
        }

        @Override
        public int compare(String string, String string2) {
            return string.toUpperCase().compareTo(string2.toUpperCase());
        }
    }
}
