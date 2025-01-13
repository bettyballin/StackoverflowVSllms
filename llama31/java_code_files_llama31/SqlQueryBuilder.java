/*
 * Decompiled with CFR 0.152.
 */
public class SqlQueryBuilder {
    String barInput = "X";
    String escapedBarInput = this.barInput.replace("'", "''");
    String query = "SELECT * FROM FOO WHERE BAR LIKE '%" + this.escapedBarInput + "%'";

    public static void main(String[] stringArray) {
        SqlQueryBuilder sqlQueryBuilder = new SqlQueryBuilder();
        System.out.println(sqlQueryBuilder.query);
    }
}
