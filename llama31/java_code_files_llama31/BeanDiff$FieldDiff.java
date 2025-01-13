/*
 * Decompiled with CFR 0.152.
 */
public static class BeanDiff.FieldDiff {
    private String fieldName;
    private Object oldValue;
    private Object newValue;

    public BeanDiff.FieldDiff(String string, Object object, Object object2) {
        this.fieldName = string;
        this.oldValue = object;
        this.newValue = object2;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String string) {
        this.fieldName = string;
    }

    public Object getOldValue() {
        return this.oldValue;
    }

    public void setOldValue(Object object) {
        this.oldValue = object;
    }

    public Object getNewValue() {
        return this.newValue;
    }

    public void setNewValue(Object object) {
        this.newValue = object;
    }
}
