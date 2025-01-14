import java.lang.String;

// Define dummy annotations
@interface Component {}
@interface Autowired {}
@interface Configurable {
    boolean preConstruction() default false;
}
@interface Entity {}

interface MyRepository {}

// Using @Component for most business/service classes
@Component
public class MyService_1 {
    private final MyRepository myRepository;

    @Autowired
    public MyService_1(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    // service methods here
}

// Reserved @Configurable usage for JPA entities or special cases like tests
@Configurable(preConstruction = true)
@Entity
public class MyEntity {
    // entity fields and methods here

    // Note: Avoid adding any business logic in entities unless absolutely necessary.

    public static void main(String[] args) {
    }
}