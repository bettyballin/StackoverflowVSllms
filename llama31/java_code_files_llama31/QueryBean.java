/*
 * Decompiled with CFR 0.152.
 */
public class QueryBean {
    private String query;

    public String search() {
        return "/result?query=" + this.query;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String string) {
        this.query = string;
    }

    public static void main(String[] stringArray) {
        QueryBean queryBean = new QueryBean();
        queryBean.setQuery("example");
        System.out.println(queryBean.search());
    }
}
