import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenericGenerator;
import javax.persistence.Column;

public class ProductEntity {
    private String productId;

    @Id
    @GeneratedValue(generator = "oracle-guid")
    @GenericGenerator(name = "oracle-guid", strategy = "guid")
    @Column(name = "PRODUCT_ID", unique = true, nullable = false)
    public String getId() {
        return this.productId;
    }

    public static void main(String[] args) {
    }
}