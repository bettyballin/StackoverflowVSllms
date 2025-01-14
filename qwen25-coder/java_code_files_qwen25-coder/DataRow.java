import java.util.ArrayList;
import java.util.List;

public class DataRow {
    private List<Object> columns = new ArrayList<>();

    public void addColumn(Object value) {
        columns.add(value);
    }

    public Object getColumn(int index) {
        return columns.get(index);
    }

    public static void main(String[] args) {
    }
}

class DataTable {
    private List<DataRow> rows = new ArrayList<>();

    public void addRow(DataRow row) {
        rows.add(row);
    }

    public DataRow getRow(int index) {
        return rows.get(index);
    }
}

class DataSet {
    private List<DataTable> tables = new ArrayList<>();

    public void addTable(DataTable table) {
        tables.add(table);
    }

    public DataTable getTable(int index) {
        return tables.get(index);
    }
}