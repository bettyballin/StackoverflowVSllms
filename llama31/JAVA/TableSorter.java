import java.lang.String;

public class TableSorter {
    private String[] sortOrder;

    public TableSorter(int numColumns) {
        sortOrder = new String[numColumns];
        for (int i = 0; i < numColumns; i++) {
            sortOrder[i] = "ASC";
        }
    }

    public void sort(int column) {
        // Implement your sort logic here
        // You can also update the sortOrder value here
        sortOrder[column] = sortOrder[column].equals("ASC") ? "DESC" : "ASC";
    }

    public String sortOrder(int column) {
        return sortOrder[column];
    }

    public static void main(String[] args) {
        TableSorter tableSorter = new TableSorter(5);
        tableSorter.sort(0);
        System.out.println(tableSorter.sortOrder(0)); // prints "DESC"
    }
}