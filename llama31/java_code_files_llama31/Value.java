/*
 * Decompiled with CFR 0.152.
 */
class Value<T> {
    private T value;
    private ValueState state;

    public Value(T t, ValueState valueState) {
        this.value = t;
        this.state = valueState;
    }

    public T getValue() {
        return this.value;
    }

    public ValueState getState() {
        return this.state;
    }

    public void setState(ValueState valueState) {
        this.state = valueState;
    }

    public void setValue(T t) {
        this.value = t;
    }
}
