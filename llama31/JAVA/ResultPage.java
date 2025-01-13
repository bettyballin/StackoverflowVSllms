import java.lang.String;

// Assuming @Page and @PageParameter are custom annotations
// If not, you need to import the correct package or define them

@Page("/result")
public class ResultPage {
  @PageParameter
  private String query;

  // getters and setters
  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public static void main(String[] args) {
  }
}