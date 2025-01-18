import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class YourEntity_2 {
  @Id
  // Custom implementation
  @GenericGenerator(name = "mixed_gen",
      strategy = "com.package.MixedIdentifierGenerator")
  @GeneratedValue(generator="mixed_gen")
  private Long id;

  public static void main(String[] args) {
  }
}