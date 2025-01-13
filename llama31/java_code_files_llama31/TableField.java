/*
 * Decompiled with CFR 0.152.
 */
class TableField {
    private String tableName;
    private String fieldName;

    public TableField(String string, String string2) {
        this.tableName = string;
        this.fieldName = string2;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setTableName(String string) {
        this.tableName = string;
    }

    public void setFieldName(String string) {
        this.fieldName = string;
    }
}
