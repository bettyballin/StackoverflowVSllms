import java.util.List;
import java.util.Arrays;

class Result {
    private boolean success;
    private int rowNumber;

    public Result(boolean success, int rowNumber) {
        this.success = success;
        this.rowNumber = rowNumber;
    }

    // Getters
    public boolean isSuccess() {
        return success;
    }

    public int getRowNumber() {
        return rowNumber;
    }
}

class DataRow {
    private List<String> values;

    public DataRow(List<String> values) {
        this.values = values;
    }

    public boolean containsValue(String value) {
        return values.contains(value);
    }
}

class DataTable {
    private List<DataRow> rows;

    public DataTable(List<DataRow> rows) {
        this.rows = rows;
    }

    public DataRow getRow(int index) {
        return rows.get(index);
    }

    public int getRowCount() {
        return rows.size();
    }
}

public class Main {
    public Result findSpecificRowValue(DataTable table, String valueToFind) {
        boolean success = false;
        int rowNumber = -1;

        // search for the row logic ...
        for (int i = 0; i < table.getRowCount(); i++) {
            DataRow row = table.getRow(i);
            if (row.containsValue(valueToFind)) {
                success = true;
                rowNumber = i;
                break;
            }
        }

        return new Result(success, rowNumber);
    }

    public static void main(String[] args) {
        // Sample data
        List<String> row1Values = Arrays.asList("alpha", "beta", "gamma");
        List<String> row2Values = Arrays.asList("delta", "epsilon", "zeta");
        List<String> row3Values = Arrays.asList("eta", "theta", "iota");

        DataRow row1 = new DataRow(row1Values);
        DataRow row2 = new DataRow(row2Values);
        DataRow row3 = new DataRow(row3Values);

        List<DataRow> rows = Arrays.asList(row1, row2, row3);
        DataTable table = new DataTable(rows);

        Main mainClass = new Main();
        Result result = mainClass.findSpecificRowValue(table, "epsilon");

        if (result.isSuccess()) {
            System.out.println("Value found at row: " + result.getRowNumber());
        } else {
            System.out.println("Value not found.");
        }
    }
}