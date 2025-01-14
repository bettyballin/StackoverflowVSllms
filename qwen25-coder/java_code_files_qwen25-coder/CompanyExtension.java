import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class CompanyExtension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fieldName;
    private String fieldType; // e.g., "String", "Integer"
    // other metadata fields like description, isRequired, etc.

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "extension")
    private List<CompanyExtensionValue> values = new ArrayList<>();

    public static void main(String[] args) {
        // Execution entry point
    }
}

@Entity
class CompanyExtensionValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "extension_id")
    private CompanyExtension extension;

    // other fields as necessary
}