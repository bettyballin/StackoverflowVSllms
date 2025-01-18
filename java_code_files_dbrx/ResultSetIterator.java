import java.sql.ResultSet;

public class ResultSetIterator {
    public static void main(String[] args) {
        ResultSet rs = null; // Assuming rs is initialized elsewhere
        while (rs.next()) { // loop through each row in the result set
            int value1 = rs.getInt("column_name1"); // get integer from column 1
            String value2 = rs.getString("column_name2"); // get string from column 2
        }
    }
}