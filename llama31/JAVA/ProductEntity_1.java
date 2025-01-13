import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenericGenerator;
import javax.persistence.Id;

public class ProductEntity_1_1 {
    private String productId;

    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "PRODUCT_ID", unique = true, nullable = false)
    public String getId() {
        return this.productId;
    }

    public static void main(String[] args) {
    }
}