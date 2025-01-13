/*
 * Decompiled with CFR 0.152.
 */
class Fact {
    private String name;
    private Object value;

    public Fact(String string, Object object) {
        this.name = string;
        this.value = object;
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() {
        return this.value;
    }
}
