import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        DataTable dtDataTable = new DataTable();
        Label lbl_count = new Label();

        if (dtDataTable != null && dtDataTable.getRows().size() > 0) {
            // some code
            lbl_count.setText("Found " + dtDataTable.getRows().size() + " results");
        } else {
            lbl_count.setText("Found 0 result");
        }

        System.out.println(lbl_count.getText());
    }
}

class DataTable {
    private ArrayList<Row> rows;

    public DataTable() {
        rows = new ArrayList<>();
        // Initialize rows with data if needed
    }

    public ArrayList<Row> getRows() {
        return rows;
    }
}

class Row {
    // Define row properties if needed
}

class Label {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}