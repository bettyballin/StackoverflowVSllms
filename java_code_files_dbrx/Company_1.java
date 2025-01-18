import java.util.Set;
import java.util.HashSet;

@interface Entity {}
@interface Embeddable {}
@interface OneToMany {
    String mappedBy() default "";
}

@Entity
class Company_1 {
    // ... other fields

    @OneToMany(mappedBy = "company")
    private Set<AdditionalProperty> properties = new HashSet<>();
}

@Embeddable
public class AdditionalProperty {
    private String name;
    private Object value;

    // getters, setters, etc.

    public static void main(String[] args) {
    }
}