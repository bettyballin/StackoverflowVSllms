import java.lang.String;
import java.util.List;

public class CustomerRepository_1 {
    public interface CustomerRepository extends JpaRepository<Customer, Long> {
        List<Customer> findByCountry(String country, Pageable pageRequest);
    }

    public static void main(String[] args) {
    }
}

interface JpaRepository<T, ID> {
    // Stub interface to make the code compile
}

class Customer {
    // Stub class to represent com.example.entity.Customer
}

class Pageable {
    // Stub class to represent org.springframework.data.domain.Pageable
}