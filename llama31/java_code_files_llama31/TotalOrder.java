/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

public class TotalOrder
implements Comparator<Object> {
    @Override
    public int compare(Object object, Object object2) {
        int n;
        if (object == object2) {
            return 0;
        }
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        int n2 = System.identityHashCode(object);
        if (n2 != (n = System.identityHashCode(object2))) {
            return n2 < n ? -1 : 1;
        }
        String string = object.toString();
        String string2 = object2.toString();
        return string.compareTo(string2);
    }

    public static void main(String[] stringArray) {
    }
}
