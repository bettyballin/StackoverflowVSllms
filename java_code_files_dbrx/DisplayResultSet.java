import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class DisplayResultSet {
    public static void main(String args[]) {
        Connection conn = null; // creating a variable for connection
        Statement stmt = null; // creating statement that will be used to execute our queries
        ResultSet rs = null;  // result set which stores the data retrieved from the database

        try {
            // STEP 1: loading drivers and registering it with DriverManager (Registry)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost\\SQLExpress;database=YourDatabase";
            conn = DriverManager.getConnection(url, "username", "password"); // creating connection by using getConnection method and passing our values to it
            stmt = conn.createStatement(); // creating statement with the help of createStatement() method of Connection interface

            if (stmt != null) { // checking if the stmt is not null
                rs = stmt.executeQuery("YOUR SQL STATEMENT"); // executing SELECT query and getting result set in 'rs' object
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            if (rs != null) {
                ResultSetMetaData rsmd = rs.getMetaData(); // gets metadata of the result set
                int columnCount = rsmd.getColumnCount(); // getting columns count so that they are printed along with values
                Vector<String> colNames = new Vector<>(); // storing column names in vector object 'colNames'
                for (int i = 1; i <= columnCount; i++) { // adding to the object one by one using add method of class Object
                    colNames.addElement(rsmd.getColumnName(i));
                }
                Vector<Vector<String>> rows = new Vector<>(); // storing rows in vector 'rows'
                while (rs.next()) { // Fetch each row from the result set and add them to our list of vectors
                    Vector<String> data = new Vector<>(); // creating object of class Vector for data every time when next is called on ResultSet object
                    for (int i = 1; i <= columnCount; i++) { // adding column values into vector 'rows'
                        data.addElement(rs.getString(i));
                    }
                    rows.addElement(data); // adding this row to our list of rows
                }
                DefaultTableModel model = new DefaultTableModel(rows, colNames) { // creating table model by passing the columns and rows
                    @Override
                    public Class<?> getColumnClass(final int columnIndex) { // which class each column will be returned when requested
                        return String.class; // We override this method to make sure all data are displayed as a string type for our purposes
                    }
                }; // Close the anonymous inner class

                JTable table = new JTable(model); // creating table and passing model to it

                // Creating the scroll pane and adding the table to it
                JScrollPane scrollpane = new JScrollPane(table);

                // Adding scroll pane component in dialog frame where you want to show your resultset
                // JOptionPane.showMessageDialog(null, new JScrollPane(table));
                JFrame f = new JFrame(); // creating instance of JFrame and setting its properties like bounds, close operation, etc.
                f.add(scrollpane); // adding scroll pane to the application window or Frame which is visible by default true
                f.setTitle("Result Set Displayed In Table"); // setting frame title
                f.pack(); // packing all components in the frame so that it takes only required space not more than that
                f.setLocationRelativeTo(null); // setting location frame to be displayed at center of screen
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setting default close operation
                f.setVisible(true); // making application window visible true
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally { // Finally block to ensure resources are closed
            if (rs != null) { // checking if the ResultSet exists
                try {
                    rs.close(); // closing the ResultSet
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) { // checking if the Statement exists
                try {
                    stmt.close(); // closing the Statement
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) { // checking if the Connection exists
                try {
                    conn.close(); // closing the Connection
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } // end of main method
    }
} // End of class DisplayResultSet