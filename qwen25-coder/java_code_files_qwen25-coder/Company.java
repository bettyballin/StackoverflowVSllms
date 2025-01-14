import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // other fields like Owner

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<CompanyExtensionValue> extensionValues = new ArrayList<>();

    // getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CompanyExtensionValue> getExtensionValues() {
        return extensionValues;
    }

    public void setExtensionValues(List<CompanyExtensionValue> extensionValues) {
        this.extensionValues = extensionValues;
    }

    // Add other getters and setters for other fields like Owner
}

@Entity
class CompanyExtensionValue {
    @ManyToOne
    private Company company;

    // other fields

    // getters and setters
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

public class Main {
    public static void main(String[] args) {
    }
}