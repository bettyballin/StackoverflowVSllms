/*
 * Decompiled with CFR 0.152.
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HierarchicalTable {
    public static void main(String[] stringArray) {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("2008");
        defaultTableModel.addColumn("January");
        defaultTableModel.addColumn("February");
        defaultTableModel.addColumn("Week1");
        defaultTableModel.addColumn("Week2");
        defaultTableModel.addColumn("Week3");
        defaultTableModel.addColumn("Week1");
        defaultTableModel.addColumn("Week2");
        defaultTableModel.addColumn("Week3");
        defaultTableModel.addRow(new Object[]{"", "", "", 10, 20, 14, 12, 15, 3});
        JTable jTable = new JTable(defaultTableModel);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        JLabel jLabel = new JLabel("2008");
        jPanel.add((Component)jLabel, "North");
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayout(1, 2));
        JLabel jLabel2 = new JLabel("January");
        JLabel jLabel3 = new JLabel("February");
        jPanel2.add(jLabel2);
        jPanel2.add(jLabel3);
        jPanel.add((Component)jPanel2, "Center");
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setRowHeaderView(jPanel);
        JFrame jFrame = new JFrame("Hierarchical Table");
        jFrame.setDefaultCloseOperation(3);
        jFrame.add(jScrollPane);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
