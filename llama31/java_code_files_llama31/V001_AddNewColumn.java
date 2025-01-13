/*
 * Decompiled with CFR 0.152.
 */
public class V001_AddNewColumn
extends BaseJavaMigration {
    @Override
    public void migrate(Context context) {
        context.getStatement().execute("ALTER TABLE mytable ADD COLUMN newcolumn VARCHAR(255)");
    }

    public static void main(String[] stringArray) {
        V001_AddNewColumn v001_AddNewColumn = new V001_AddNewColumn();
        v001_AddNewColumn.migrate(new Context());
    }
}
