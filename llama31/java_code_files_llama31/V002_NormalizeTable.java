/*
 * Decompiled with CFR 0.152.
 */
class V002_NormalizeTable
extends BaseJavaMigration {
    V002_NormalizeTable() {
    }

    @Override
    public void migrate(Context context) {
        context.getStatement().execute("CREATE TABLE normalized_table (id INT PRIMARY KEY, name VARCHAR(255))");
        context.getStatement().execute("INSERT INTO normalized_table SELECT id, name FROM mytable");
        context.getStatement().execute("DROP TABLE mytable");
    }

    public static void main(String[] stringArray) {
        V002_NormalizeTable v002_NormalizeTable = new V002_NormalizeTable();
        v002_NormalizeTable.migrate(new Context());
    }
}
