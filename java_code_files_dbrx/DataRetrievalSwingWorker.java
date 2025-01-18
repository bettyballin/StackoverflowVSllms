import javax.swing.SwingWorker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataRetrievalSwingWorker extends SwingWorker<Void, Void> {
    // your connection handling here ...
    private RecordsTableModel model;

    public DataRetrievalSwingWorker(RecordsTableModel model) {
        this.model = model;
    }

    @Override
    protected Void doInBackground() throws Exception {
        Connection con = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:your_database_url"); // open your data connection here using your preferred library, in Java it's usually JDBC
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT name, age FROM your_table");  // prepare and execute the SQL SELECT Query here!
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                // get other fields

                Record record = new Record(name, age); // create a new record
                model.addRecord(record); // update the table data in EDT (Event Dispatch Thread). However in production code you should use synchronize or other concurrency control methods to avoid race conditions!
            }
        } catch (SQLException e) {
            // handle exception
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ex) { /* Ignore close errors */ }
            try { if (con != null) con.close(); } catch (SQLException ex) { /* Ignore close errors */ }
        }
        return null;
    }
}

class Record {
    private String name;
    private int age;
    // other fields

    public Record(String name, int age) {
        this.name = name;
        this.age = age;
        // initialize other fields
    }
    // getters and setters if needed
}

class RecordsTableModel {
    public void addRecord(Record record) {
        // implementation to add record to table model
    }
}