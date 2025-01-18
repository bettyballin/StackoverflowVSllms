public class FooReference {
    private Long fooId;
    private Item item;

    // Constructors
    public FooReference() {
    }

    public FooReference(Long fooId, Item item) {
        this.fooId = fooId;
        this.item = item;
    }

    // Getters and Setters
    public Long getFooId() {
        return fooId;
    }

    public void setFooId(Long fooId) {
        this.fooId = fooId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setFoo(Foo foo) {
        this.fooId = foo.getId();
    }

    public static void main(String[] args) {
    }
}

class Foo {
    private Long id;

    // Constructors
    public Foo() {
    }

    public Foo(Long id) {
        this.id = id;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

class Item {
    // Item class definition
}