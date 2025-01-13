import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;

@Entity
@Table(name = "foo")
public class Foo_2_2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fooId;

    @OneToMany(mappedBy = "foo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bar> bars;

    // getters and setters

    public Long getFooId() {
        return fooId;
    }

    public void setFooId(Long fooId) {
        this.fooId = fooId;
    }

    public List<Bar> getBars() {
        return bars;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

    public static void main(String[] args) {
    }
}