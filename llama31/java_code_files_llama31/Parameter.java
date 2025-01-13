/*
 * Decompiled with CFR 0.152.
 */
class Parameter<T> {
    public static final Parameter<String> CTITLE = new Parameter();
    private T value;

    Parameter() {
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T t) {
        this.value = t;
    }
}
