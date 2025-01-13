/*
 * Decompiled with CFR 0.152.
 */
public class QuerySplitter {
    String sqlQuery1 = "SELECT ... FROM ...";
    String sqlQuery2 = "JOIN ... ON ...";
    String sqlQuery3 = "WHERE ...";

    public static void main(String[] stringArray) {
        QuerySplitter querySplitter = new QuerySplitter();
        System.out.println(querySplitter.sqlQuery1);
        System.out.println(querySplitter.sqlQuery2);
        System.out.println(querySplitter.sqlQuery3);
    }
}
