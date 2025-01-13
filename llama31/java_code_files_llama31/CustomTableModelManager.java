/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JTable;

public class CustomTableModelManager {
    public static void main(String[] stringArray) {
        JTable jTable = new JTable();
        CustomTableColumnModel customTableColumnModel = new CustomTableColumnModel();
        jTable.setColumnModel(customTableColumnModel);
    }
}
