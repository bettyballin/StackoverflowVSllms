import java.lang.String;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    public static void main(String[] args) {
    }
}

// Define annotations

@interface RestController {
}

@interface RequestMapping {
    String value();
}

@interface Autowired {
}

@interface PostMapping {
}

@interface RequestBody {
}

// Define placeholder classes

class Customer {
}

class CustomerService {
    public Customer addCustomer(Customer customer) {
        return customer;
    }
}

class ResponseEntity<T> {
    public ResponseEntity(T body, HttpStatus status) {
    }
}

enum HttpStatus {
    CREATED;
}