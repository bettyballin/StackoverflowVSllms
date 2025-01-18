import java.util.ArrayList;
import java.util.List;

public class Foo_7 {
    private Long id;
    private List<Bar> bars = new ArrayList<>();

    // Getters and setters of above fields as well as constructors
    public Foo_7() {
    }

    public Foo_7(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Bar> getBars() {
        return bars;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

    public void addBar(Bar bar) {
        bar.setFoo(this);
        this.bars.add(bar); // assuming that item order is same as the index in this list, otherwise we'll need to maintain a separate property for item_order column.
    }

    public static void main(String[] args) {
    }
}

class Bar {
    public void setFoo(Foo_7 foo) {
        // Method implementation
    }
}