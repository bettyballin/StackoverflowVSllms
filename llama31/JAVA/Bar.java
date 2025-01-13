import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Embeddable;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bar")
public class Bar {
    @EmbeddedId
    private BarId id;

    @ManyToOne
    @JoinColumn(name = "foo_id", insertable = false, updatable = false)
    private Foo foo;

    // getters and setters
    public BarId getId() {
        return id;
    }

    public void setId(BarId id) {
        this.id = id;
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }
}

@Embeddable
public class BarId implements Serializable {
    @Column(name = "foo_id")
    private Long fooId;

    @Column(name = "item")
    private String item;

    // getters and setters
    public Long getFooId() {
        return fooId;
    }

    public void setFooId(Long fooId) {
        this.fooId = fooId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarId barId = (BarId) o;
        return Objects.equals(fooId, barId.fooId) &&
                Objects.equals(item, barId.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fooId, item);
    }

    public static void main(String[] args) {
    }
}

class Foo {
    // Add Foo class implementation here
}