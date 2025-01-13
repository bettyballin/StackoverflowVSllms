import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class VendorSearcher {
    private JTextField jTextField2;
    private JTextArea DisplayAreaX;
    private Statement stmt;

    public VendorSearcher() {
        // Initialize jTextField2, DisplayAreaX, and stmt
        // These variables should be initialized before using them
        // For example:
        // jTextField2 = new JTextField();
        // DisplayAreaX = new JTextArea();
        // stmt = connection.createStatement();
    }

    public void searchVendors() {
        try {
            ResultSet rs;
            String comparex = jTextField2.getText().trim().toUpperCase();
            rs = stmt.executeQuery(
                "SELECT * FROM BASTIMP where DETAILS like '%"+comparex+"%'"
            );
            String amount;
            String date;
            String attached = "";

            if (!rs.next()) {
                DisplayAreaX.setText("ENTER VALID VENDOR");
            } else {
                do {
                    String details = rs.getString("DETAILS");
                    date = rs.getString("DATE PAID");
                    amount = rs.getString("AMOUNT BANK");
                    attached = attached + details + ":" + "\n" + "Date " + date + " / " + "Amount £" + amount + "\n";
                    DisplayAreaX.setText(attached);
                    System.out.println(details + ":" + "\n" + "Date " + date + " / " + "Amount £" + amount + "\n");
                } while (rs.next());
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
        }
    }

    public static void main(String[] args) {
        VendorSearcher searcher = new VendorSearcher();
        searcher.searchVendors();
    }
}