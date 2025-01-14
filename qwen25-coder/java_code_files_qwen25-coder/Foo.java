import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.ParamDef;

@Entity
@FilterDefs({
    @FilterDef(name = "deletedBarFilter", parameters = {
        @ParamDef(name = "isDeleted", type = "boolean")
    })
})
public class Foo {

    @OneToMany(mappedBy = "foo", cascade = CascadeType.ALL, orphanRemoval = true)
    @Filter(name = "deletedBarFilter", condition = "deleted = :isDeleted")
    private List<Bar> bars;

    // getters and setters
    public List<Bar> getBars() {
        return bars;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

    public static void main(String[] args) {
    }
}

@Entity
public class Bar {

    @ManyToOne
    private Foo foo;

    private boolean deleted;

    // getters and setters
    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}