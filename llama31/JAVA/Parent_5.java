import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
public class Parent_5_5 {
  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
  private List<Child> children;

  public static void main(String[] args) {
  }
}