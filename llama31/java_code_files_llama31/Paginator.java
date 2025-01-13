/*
 * Decompiled with CFR 0.152.
 */
public class Paginator {
    public static int getTotalRecordsFromDB() {
        return 1000;
    }

    public static void main(String[] stringArray) {
        Paginator paginator = new Paginator();
        paginator.paginate();
    }

    public void paginate() {
        int n = Paginator.getTotalRecordsFromDB();
        int n2 = 100;
        int n3 = (int)Math.ceil((double)n / (double)n2);
        int n4 = 1;
        int n5 = (n4 - 1) * n2;
        String string = "SELECT * FROM table_name LIMIT " + n2 + " OFFSET " + n5;
        System.out.println("Total Records: " + n);
        System.out.println("Total Pages: " + n3);
        System.out.println("Query: " + string);
    }
}
