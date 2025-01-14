public class DatabaseHelper_2 {
    String val = getCell("SELECT col FROM table WHERE other_col LIKE ?", new String[]{"%value%"});

    public static void main(String[] args) {
    }

    public String getCell(String query, String[] params) {
        // Method implementation goes here
        return null;
    }
}