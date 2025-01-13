/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DatabaseTableExample {
    public static void main(String[] stringArray) {
        Object object;
        Object object2;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("url", "username", "password");
        }
        catch (SQLException sQLException) {
            System.out.println("Error connecting to database");
            return;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Age");
        defaultTableModel.addColumn("City");
        defaultTableModel.addColumn("Date");
        try {
            object2 = connection.createStatement();
            object = object2.executeQuery("SELECT * FROM your_table");
            while (object.next()) {
                defaultTableModel.addRow(new Object[]{object.getString(1), object.getInt(2), object.getString(3), object.getDate(4)});
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error retrieving data from database");
        }
        object2 = new JTable(defaultTableModel);
        object = new JFrame();
        ((JFrame)object).setDefaultCloseOperation(3);
        ((Container)object).add(new JScrollPane((Component)object2));
        ((Window)object).pack();
        ((Window)object).setVisible(true);
    }
}
