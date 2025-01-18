import java.sql.*;
import javax.swing.*;

public class DatabaseQuery {
    public static void main(String[] args) {
        try {
            // Assuming 'conn' is a valid database connection
            Connection conn = null; // Should be initialized with a real connection
            Statement stmt = conn.createStatement();
            JTextField jTextField2 = new JTextField();
            JTextArea DisplayAreaX = new JTextArea();

            ResultSet rs;
            String comparex = jTextField2.getText().trim().toUpperCase(); // puts the textfield into a string object
            rs = stmt.executeQuery("SELECT * FROM BASTIMPEMP where DETAILS like '%" + comparex + "%'");

            String amount;
            String date;
            String attached = "";
            boolean hasFirstRow = rs.next(); // Move cursor to first row, check if there is a result.

            if (!hasFirstRow) {
                // No results were found... show the message and exit.
                DisplayAreaX.setText("ENTER VALID VENDOR");
                return;
            } 
            do {
                // Since at least one record has been returned, process the results.
                String details = rs.getString("DETAILS"); // get results from DETAILS
                date = rs.getString("DATE PAID");
                amount = rs.getString("AMOUNT BA"); // Adjust the column name as per your table
                attached = attached + details + ":" + '\n' + "Date " + date + " / " +
                        "Amount £" + amount + '\n';

                DisplayAreaX.setText(attached); // Consider collecting results and setting the text after the loop for better performance.
                System.out.println(details + ":" + '\n' + "Date " + date + " / " +
                        "Amount £" + amount + '\n');
            } while (rs.next()); // Continue looping while there are more rows.
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString()); // Use a logging framework for detailed logs.
        }
    }
}