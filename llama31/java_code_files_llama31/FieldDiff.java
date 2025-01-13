/*
 * Decompiled with CFR 0.152.
 */
class FieldDiff {
    private String fieldName;
    private Object oldValue;
    private Object newValue;

    public FieldDiff(String string, Object object, Object object2) {
        this.fieldName = string;
        this.oldValue = object;
        this.newValue = object2;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Object getOldValue() {
        return this.oldValue;
    }

    public Object getNewValue() {
        return this.newValue;
    }
}
