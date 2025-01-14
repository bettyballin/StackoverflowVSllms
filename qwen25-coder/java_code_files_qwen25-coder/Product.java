import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "PRODUCT", schema = "SCHEMA_NAME")
public class Product {

    @Id
    @GeneratedValue(generator = "system-guid")
    @GenericGenerator(
        name = "system-guid",
        strategy = "guid"
    )
    @Column(name = "PRODUCT_ID", unique = true, nullable = false)
    private String productId;

    // Other fields and methods

    public String getId() {
        return this.productId;
    }

    // Getters and setters for other fields

    public static void main(String[] args) {
    }
}