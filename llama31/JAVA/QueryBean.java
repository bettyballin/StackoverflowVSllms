import java.lang.String;

public class QueryBean {
  private String query;

  public String search() {
    return "/result?query=" + query;
  }

  // getters and setters
  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public static void main(String[] args) {
    QueryBean queryBean = new QueryBean();
    queryBean.setQuery("example");
    System.out.println(queryBean.search());
  }
}