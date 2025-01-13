/*
 * Decompiled with CFR 0.152.
 */
public static class NullableOptionsFactory.Option<T> {
    private T value;

    public NullableOptionsFactory.Option(T t) {
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }
}
