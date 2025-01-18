import java.util.List;

public class ClassA {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "COLUMN_NAME")
    @OrderBy("classC.name ASC") // Add this line to sort the collection by ClassC's name property
    private List<ClassB> lotsOfClasses;

    public static void main(String[] args) {
    }
}

class ClassB {
    private ClassC classC;

    public ClassC getClassC() {
        return classC;
    }

    public void setClassC(ClassC classC) {
        this.classC = classC;
    }
}

class ClassC {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// Annotation definitions
@interface OneToMany {
    CascadeType[] cascade() default {};
    FetchType fetch() default FetchType.LAZY;
}

@interface JoinColumn {
    String name();
}

@interface OrderBy {
    String value();
}

// Enum definitions
enum CascadeType {
    ALL, PERSIST, MERGE, REMOVE, REFRESH, DETACH;
}

enum FetchType {
    LAZY, EAGER;
}