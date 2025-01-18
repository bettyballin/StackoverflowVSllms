import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class A_1 {
    @ManyToOne
    private B b;
}

@Entity
public class B {
    @OneToMany(mappedBy = "b")
    private List<A_1> as;

    public static void main(String[] args) {
    }
}