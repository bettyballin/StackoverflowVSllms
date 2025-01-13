/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

static class TableModelChangeListener.1
implements TableModelListener {
    final /* synthetic */ JTable val$table;
    final /* synthetic */ TableModel val$model;

    TableModelChangeListener.1() {
        this.val$table = jTable;
        this.val$model = tableModel;
    }

    @Override
    public void tableChanged(TableModelEvent tableModelEvent) {
        this.val$table.setModel(this.val$model);
    }
}
