import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {
    private final int BATCH_SIZE = 50;
    @Autowired
    private CustomerRepository customerRepo;

    public List<Customer> getCustomersInBatches(String country) {
        List<Customer> customersList = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0, BATCH_SIZE); // Start from first page and fetch 50 records at a time
        boolean hasNextPage;

        do {
            Optional<List<Customer>> optionalCustomers = customerRepo.findByCountry(country, pageRequest);
            if (optionalCustomers.isPresent()) {
                List<Customer> customersOfPage = optionalCustomers.get();
                PageRequest nextPageRequest;
                if (customersOfPage.size() < BATCH_SIZE) { // If the last page size is smaller than BATCH_SIZE, there's no need to fetch more pages
                    hasNextPage = false;
                    customersList.addAll(customersOfPage);
                } else {
                    nextPageRequest = PageRequest.of(pageRequest.getPageNumber() + 1, BATCH_SIZE); // Fetch the next page of records
                    hasNextPage = true;
                    customersList.addAll(customersOfPage);
                }
            } else { // If Optional returned empty list, no need to fetch more pages
                break;
            }
        } while (hasNextPage);
        return customersList;
    }

    public static void main(String[] args) {
    }
}

interface CustomerRepository {
    Optional<List<Customer>> findByCountry(String country, PageRequest pageRequest);
}

class PageRequest {
    private int page;
    private int size;

    private PageRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public static PageRequest of(int page, int size) {
        return new PageRequest(page, size);
    }

    public int getPageNumber() {
        return page;
    }
}

class Customer {
    // Empty class for compilation
}

@interface Autowired {
    // Empty annotation for compilation
}