import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "documents")
public class Document_1_1 {
  @Id
  private Long id;
  private String content;
  @Version
  private Long version;

  // getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public static void main(String[] args) {
    // Example usage
    Document_1 document = new Document_1();
    document.setId(1L);
    document.setContent("This is a sample document.");
    document.setVersion(1L);
    // Persistence code would go here, using Hibernate or another JPA provider.
  }
}