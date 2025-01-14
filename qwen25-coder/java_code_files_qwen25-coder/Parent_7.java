import java.util.Set;

// Example of setting up a cascade in JPA/Hibernate annotation

@Entity
public class Parent_7 {
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Child> children;

    public static void main(String[] args) {
    }
}

// Define the @Entity annotation
@interface Entity {}

// Define the @OneToMany annotation
@interface OneToMany {
    String mappedBy() default "";
    CascadeType[] cascade() default {};
}

// Define the CascadeType enum
enum CascadeType {
    ALL
}

// Define the Child class
class Child {
    Parent_7 parent;
}