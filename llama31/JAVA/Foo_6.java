import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Filter;
import java.util.List;

@Entity
public class Foo_6_6 {
    @OneToMany(mappedBy = "foo")
    @Filter(name = "deletedFilter", condition = "deleted = false")
    private List<Bar> bars;

    public static void main(String[] args) {
    }
}