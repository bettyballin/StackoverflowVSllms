/*
 * Decompiled with CFR 0.152.
 */
public class TableSorter {
    private String[] sortOrder;

    public TableSorter(int n) {
        this.sortOrder = new String[n];
        for (int i = 0; i < n; ++i) {
            this.sortOrder[i] = "ASC";
        }
    }

    public void sort(int n) {
        this.sortOrder[n] = this.sortOrder[n].equals("ASC") ? "DESC" : "ASC";
    }

    public String sortOrder(int n) {
        return this.sortOrder[n];
    }

    public static void main(String[] stringArray) {
        TableSorter tableSorter = new TableSorter(5);
        tableSorter.sort(0);
        System.out.println(tableSorter.sortOrder(0));
    }
}
