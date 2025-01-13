/*
 * Decompiled with CFR 0.152.
 */
public class TableRowManager {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void createRow(int n) {
        Class<TableRowManager> clazz = TableRowManager.class;
        synchronized (TableRowManager.class) {
            Row row = this.dao().fetch(n);
            if (row == null) {
                this.dao().create(n);
            }
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return;
        }
    }

    private RowDAO dao() {
        return new RowDAO(this);
    }

    public static void main(String[] stringArray) {
        TableRowManager tableRowManager = new TableRowManager();
        tableRowManager.createRow(1);
    }

    private class RowDAO {
        private RowDAO(TableRowManager tableRowManager) {
        }

        public Row fetch(int n) {
            return null;
        }

        public void create(int n) {
        }
    }

    private class Row {
        private Row(TableRowManager tableRowManager) {
        }
    }
}
