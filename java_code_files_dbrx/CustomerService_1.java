import java.lang.String;

@Component // this gets registered as Spring bean automatically if component scanning enabled
public class CustomerService_1 {
    private final CustomerRepository repository;

    @Autowired // let spring initialize this field for you on instantiation of the service.
    public CustomerService_1(CustomerRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
    }
}

// Dummy annotations to avoid compilation errors
@interface Component { }
@interface Autowired { }

// Dummy CustomerRepository class
class CustomerRepository {
    // Empty class for compilation
}