/*
 * Decompiled with CFR 0.152.
 */
public static class NullableOptionsFactory.NotNull<T> {
    private T value;

    public NullableOptionsFactory.NotNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }
}
