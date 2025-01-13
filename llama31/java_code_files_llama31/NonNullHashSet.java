/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;

public class NonNullHashSet<T>
extends HashSet<T> {
    @Override
    public boolean add(T t) {
        if (t == null) {
            throw new NullPointerException("Cannot add null to this set");
        }
        return super.add(t);
    }

    public static void main(String[] stringArray) {
        NonNullHashSet<String> nonNullHashSet = new NonNullHashSet<String>();
        nonNullHashSet.add("hello");
        try {
            nonNullHashSet.add(null);
        }
        catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException.getMessage());
        }
    }
}
