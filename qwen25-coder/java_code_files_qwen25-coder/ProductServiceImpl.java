import java.util.List;
import java.util.Arrays;

// Interface for Service
interface ProductService {
    List<Product> getProducts();
}

// SOA Service Example (could be implemented via REST, SOAP etc.)
class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getProducts() {
        // Service operation logic here
        return fetchFromDatabaseOrAPI();
    }

    private List<Product> fetchFromDatabaseOrAPI() {
        // Simulate fetching data from a service
        return Arrays.asList(new Product("Laptop"), new Product("Desktop"));
    }
}

// Product class definition
class Product {
    private String name;
    public Product(String name) {
        this.name = name;
    }
    public String getName() { return name; }
}

// MVC Model Example
public class ProductModel {
    private ProductService productService;

    public ProductModel(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProductsFromService() {
        // Delegate to service layer for data retrieval
        return productService.getProducts();
    }

    public static void main(String[] args) {
    }
}