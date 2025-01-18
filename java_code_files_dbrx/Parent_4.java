import java.util.UUID;
import java.util.List;

// Define annotations and enum used in the code
@interface Id {
}

@interface ManyToMany {
    CascadeType[] cascade() default {};
}

@interface JoinTable {
    String name();

    JoinColumn[] joinColumns();

    JoinColumn[] inverseJoinColumns();
}

@interface JoinColumn {
    String name();
}

enum CascadeType {
    ALL
}

class Parent_4 {
    @Id
    private UUID id;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "link_table",
        joinColumns = {@JoinColumn(name = "parent_id")},
        inverseJoinColumns = {@JoinColumn(name = "child_id")}
    )
    private List<Child> children;

    //...getters and setters
}

public class Child {
    @Id
    private UUID id;

    //...fields, getters and setters

    public static void main(String[] args) {
    }
}