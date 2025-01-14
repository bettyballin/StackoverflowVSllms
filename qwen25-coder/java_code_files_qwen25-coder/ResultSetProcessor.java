import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ResultSetProcessor {
    public static void main(String[] args) {
        try {
            JTextField jTextField2 = new JTextField();
            JTextArea DisplayAreaX = new JTextArea();
            Statement stmt = null; // Statement initialization
            ResultSet rs;
            String comparex = jTextField2.getText().trim().toUpperCase(); // puts the textfield into a string object

            rs = stmt.executeQuery(
                "SELECT * FROM BASTIMP where DETAILS like '%" + comparex + "%'"
            ); //paradox equivalent '..comparex..'
            String amount;
            String date;
            String attached = "";

            boolean hasRecords = false; // flag to check if there are any records
            while (rs.next()) { // this while loop will handle all entries including the first one
                hasRecords = true;
                String details = rs.getString("DETAILS"); //get results from DETAILS
                date = rs.getString("DATE PAID");
                amount = rs.getString("AMOUNT BANK");
                attached = attached + details + ":" + '\n' + "Date " + date + " / " +
                           "Amount £" + amount + '\n'; // - ADDS MULTIPLE ENTRIES ON OUTPUT OF jList!
                DisplayAreaX.setText(attached);
                System.out.println(details + ":" + '\n' + "Date " + date + " / " +
                                   "Amount £" + amount + '\n');
            }

            if (!hasRecords) {
                DisplayAreaX.setText("ENTER VALID VENDOR");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
    }
}