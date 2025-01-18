import java.lang.String;

@interface PostConstruct {}

@interface ManagedBean {
    String name();
}

@interface RequestScoped {}

@ManagedBean(name = "bean")
@RequestScoped
public class Bean {
  private String query;

  @PostConstruct public void init() {  }

  public String getQuery() { return this.query; }

  public void setQuery(String query) { this.query = query; }

  public static void main(String[] args) {
  }
}