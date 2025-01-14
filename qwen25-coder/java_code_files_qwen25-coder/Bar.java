import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bar")
public class Bar {

    @EmbeddedId
    private BarPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("fooId") // Maps to the foreign key property within BarPK
    @JoinColumn(name = "foo_id")
    private Foo foo;

    @Column(name = "item")
    private String item;  // This is part of the composite key and directly mapped

    // Constructors
    public Bar() {
    }

    public Bar(BarPK id, Foo foo, String item) {
        this.id = id;
        this.foo = foo;
        this.item = item;
    }

    // Getters and setters
    public BarPK getId() {
        return id;
    }

    public void setId(BarPK id) {
        this.id = id;
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public static class BarPK implements Serializable {
        private Long fooId;
        private String item;

        // No-argument constructor
        public BarPK() {
        }

        public BarPK(Long fooId, String item) {
            this.fooId = fooId;
            this.item = item;
        }

        // Getters and setters

        @Column(name = "foo_id")
        public Long getFooId() {
            return fooId;
        }

        public void setFooId(Long fooId) {
            this.fooId = fooId;
        }

        @Column(name = "item")
        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        // equals() and hashCode() overridden

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BarPK)) return false;
            BarPK barPK = (BarPK) o;
            return fooId.equals(barPK.fooId) &&
                    item.equals(barPK.item);
        }

        @Override
        public int hashCode() {
            int result = fooId.hashCode();
            result = 31 * result + item.hashCode();
            return result;
        }
    }

    public static void main(String[] args) {
        // Main method implementation
    }
}

// Define the Foo class to allow compilation

@Entity
@Table(name = "foo")
class Foo {
    @Id
    private Long id;

    public Foo() {
    }

    public Foo(Long id) {
        this.id = id;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}