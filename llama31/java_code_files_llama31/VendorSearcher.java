/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VendorSearcher {
    private JTextField jTextField2;
    private JTextArea DisplayAreaX;
    private Statement stmt;

    public void searchVendors() {
        try {
            String string = this.jTextField2.getText().trim().toUpperCase();
            ResultSet resultSet = this.stmt.executeQuery("SELECT * FROM BASTIMP where DETAILS like '%" + string + "%'");
            Object object = "";
            if (!resultSet.next()) {
                this.DisplayAreaX.setText("ENTER VALID VENDOR");
            } else {
                do {
                    String string2 = resultSet.getString("DETAILS");
                    String string3 = resultSet.getString("DATE PAID");
                    String string4 = resultSet.getString("AMOUNT BANK");
                    object = (String)object + string2 + ":\nDate " + string3 + " / Amount \u00a3" + string4 + "\n";
                    this.DisplayAreaX.setText((String)object);
                    System.out.println(string2 + ":\nDate " + string3 + " / Amount \u00a3" + string4 + "\n");
                } while (resultSet.next());
            }
        }
        catch (SQLException sQLException) {
            System.out.println("SQL Exception: " + sQLException.toString());
        }
        catch (Exception exception) {
            System.out.println("Exception: " + exception.toString());
        }
    }

    public static void main(String[] stringArray) {
        VendorSearcher vendorSearcher = new VendorSearcher();
        vendorSearcher.searchVendors();
    }
}
