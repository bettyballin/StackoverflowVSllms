import java.util.List;

public class BikeOwner {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "owner", orphanRemoval = true)
    private List<Bike> bikes;

    public static void main(String[] args) {
    }
}

class Bike {
}

@interface OneToMany {
    CascadeType[] cascade() default {};

    FetchType fetch() default FetchType.LAZY;

    String mappedBy() default "";

    boolean orphanRemoval() default false;
}

enum CascadeType {
    ALL, PERSIST, MERGE, REMOVE, REFRESH, DETACH
}

enum FetchType {
    EAGER, LAZY
}