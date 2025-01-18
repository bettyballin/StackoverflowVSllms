import java.lang.String;

@interface Entity {
}

@interface ManyToOne {
    CascadeType[] cascade() default {};
}

enum CascadeType {
    ALL;
}

public class EntityA {
    // ...
}

@Entity
public class EntityB {
    // ...
    @ManyToOne(cascade = CascadeType.ALL)
    private EntityA entityA;
    // ...

    public static void main(String[] args) {
    }
}