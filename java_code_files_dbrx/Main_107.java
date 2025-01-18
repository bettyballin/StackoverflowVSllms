public class Main {
    public static void main(String[] args) {
        // First get the DataTable object
        DataTable dt = qtpApp.DataTable;

        // Assuming firstRow and secondRow are both integer variables representing row numbers
        int firstRow = 0; // Example value
        int secondRow = 1; // Example value

        // You can use a simple loop to compare corresponding cells in each respective row of your data table:
        for (int columnIndex = 0; columnIndex < dt.GetNumberOfColumns(); columnIndex++) {
            String columnName = dt.Caption(1, columnIndex);
            if (!dt.GetString(columnName, firstRow).equals(dt.GetString(columnName, secondRow))) {
                // Remember the rows index starts at 0 but row count does not, so add 2 here!
                Reporter.ReportEvent(
                    "Column " + columnName
                    + ": Row " + (firstRow + 2)
                    + " :" + dt.GetString(columnName, firstRow)
                    + " != Row " + (secondRow + 2)
                    + ": " + dt.GetString(columnName, secondRow)
                );
            }
        }
    }
}

class qtpApp {
    public static DataTable DataTable = new DataTable();
}

class DataTable {
    public int GetNumberOfColumns() {
        // Implement the logic to return the number of columns
        return 5; // Example value
    }

    public String GetString(String columnName, int rowIndex) {
        // Implement the logic to get the string from the data table
        // For demonstration purposes, return some value
        return "value_" + columnName + "_" + rowIndex;
    }

    public String Caption(int param1, int columnIndex) {
        // Implement the logic to get the caption
        return "ColumnCaption_" + columnIndex;
    }
}

class Reporter {
    public static void ReportEvent(String message) {
        System.out.println(message);
    }
}