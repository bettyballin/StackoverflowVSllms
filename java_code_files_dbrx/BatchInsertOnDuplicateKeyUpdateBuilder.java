import java.util.List;
import java.util.ArrayList;

public class BatchInsertOnDuplicateKeyUpdateBuilder {
    String sql = "INSERT INTO table (unique_column, counter) VALUES ";
    List<String> list = new ArrayList<>();

    {
        // For demonstration purposes, we'll add some items to the list
        list.add("item1");
        list.add("item2");
        list.add("item3");

        for(int i = 0; i < list.size(); i++) {
            sql += "(?, ?)" + (i != list.size() -1? ", ": "") ; // concatenate the values with placeholders for parameterized queries and separate by commas; add no comma after the last one.
        }
        sql += "ON DUPLICATE KEY UPDATE counter = counter + VALUES(counter);";
    }

    public static void main(String[] args) {
        BatchInsertOnDuplicateKeyUpdateBuilder builder = new BatchInsertOnDuplicateKeyUpdateBuilder();
        // Output the generated SQL statement
        System.out.println(builder.sql);
    }
}