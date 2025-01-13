import java.util.List;
import java.util.ArrayList;

// Define a simple Row class for demonstration
class Row {
    private String data;

    public Row(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

// Insertion buffer
public class InsertionBuffer {
    private List<Row> rows;

    public InsertionBuffer() {
        this.rows = new ArrayList<>();
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    public void flush() {
        // Basic implementation of flush for demonstration
        // In a real scenario, you'd implement actual logic to write to disk
        System.out.println("Flushing buffer to disk...");
        for (Row row : rows) {
            System.out.println("Writing row to disk: " + row.getData());
        }
        System.out.println("Buffer flushed to disk.");
        // Clear the buffer after flushing
        rows.clear();
    }

    public static void main(String[] args) {
        InsertionBuffer buffer = new InsertionBuffer();
        buffer.addRow(new Row("Data Row 1"));
        buffer.addRow(new Row("Data Row 2"));
        buffer.flush();
    }
}