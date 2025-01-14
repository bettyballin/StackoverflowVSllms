import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.sql.ResultSet;
import java.sql.SQLException;

// Define stubs for annotations if not using Spring Framework
@interface Service {
}

@interface Value {
    String value();
}

// Define a stub for the JdbcTemplate class
class JdbcTemplate {
    public <T> List<T> query(String sql, Map<String, Object> params, RowMapper<T> rowMapper) {
        // Implementation here
        return null;
    }
}

// Define the RowMapper interface
interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws SQLException;
}

// Define the ProductSku class
class ProductSku {
    // Implement necessary fields and methods
}

@Service
public class ProductService {

    private final JdbcTemplate jdbcTemplate;

    @Value("${FIND_ALL_BY_CHEAPEST_AND_PRODUCT_IDS}")
    private String findAllByCheapestAndProductIds;

    public ProductService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProductSku> findProducts(List<Long> productIds) {
        Map<String, Object> params = new HashMap<>();
        params.put("productIds", productIds);
        return jdbcTemplate.query(findAllByCheapestAndProductIds, params, (rs, rowNum) -> mapRow(rs));
    }

    private ProductSku mapRow(ResultSet rs) throws SQLException {
        // Mapping logic here
        return new ProductSku();
    }

    public static void main(String[] args) {
        // Example usage
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        ProductService productService = new ProductService(jdbcTemplate);

        // Assume we have a list of product IDs
        // List<Long> productIds = Arrays.asList(1L, 2L, 3L);
        // List<ProductSku> products = productService.findProducts(productIds);
    }
}