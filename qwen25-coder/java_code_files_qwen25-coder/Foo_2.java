import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "foo")
public class Foo_2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foo_id")
    private Long fooId;

    @OneToMany(mappedBy = "foo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bar> bars = new ArrayList<>();

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

    public void addBar(Bar bar) {
        bars.add(bar);
        bar.setFoo(this);
    }

    public void removeBar(Bar bar) {
        bars.remove(bar);
        bar.setFoo(null);
    }

    public static void main(String[] args) {
    }
}

class Bar {
    public void setFoo(Foo_2 foo) {
        // method implementation
    }
}