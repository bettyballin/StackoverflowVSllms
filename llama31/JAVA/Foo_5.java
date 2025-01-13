import java.lang.String;
import java.util.List; // Import java.util.List instead of java.lang.List
import javax.persistence.Entity; // Import @Entity annotation
import javax.persistence.OneToMany; // Import @OneToMany annotation
import javax.persistence.Where; // Import @Where annotation

@Entity
public class Foo_5_5 {
    @OneToMany(mappedBy = "foo")
    @Where(clause = "deleted = false")
    private List<Bar> bars;

    public static void main(String[] args) {
    }
}