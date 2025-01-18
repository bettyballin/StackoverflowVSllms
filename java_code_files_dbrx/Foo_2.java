import java.util.List;

// Define the necessary annotations as empty interfaces
@interface Entity {}

@interface OneToMany {
    String mappedBy();
}

@interface Filter {
    String name();
    String condition();
}

// Define the classes
@Entity
class Foo {

    @OneToMany(mappedBy = "foo")
    @Filter(name="notDeleted", condition="deleted = 0") // filtering Bar entities where 'deleted' field is false
    private List<Bar> bars;

    // Getters and setters
    public List<Bar> getBars() {
        return bars;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }
}

class Bar {
    // Assume Bar has a 'deleted' field
    private int deleted;

    // Reference back to Foo
    private Foo foo;

    // Getters and setters
    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }
}