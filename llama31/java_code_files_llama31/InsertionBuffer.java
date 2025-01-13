/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class InsertionBuffer {
    private List<Row> rows = new ArrayList<Row>();

    public void addRow(Row row) {
        this.rows.add(row);
    }

    public void flush() {
        System.out.println("Flushing buffer to disk...");
        for (Row row : this.rows) {
            System.out.println("Writing row to disk: " + row.getData());
        }
        System.out.println("Buffer flushed to disk.");
        this.rows.clear();
    }

    public static void main(String[] stringArray) {
        InsertionBuffer insertionBuffer = new InsertionBuffer();
        insertionBuffer.addRow(new Row("Data Row 1"));
        insertionBuffer.addRow(new Row("Data Row 2"));
        insertionBuffer.flush();
    }
}
