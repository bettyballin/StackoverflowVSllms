import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "virtual_column_data")
public class VirtualColumnData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "virtual_column_id")
    private VirtualColumn virtualColumn;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private String value;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VirtualColumn getVirtualColumn() {
        return virtualColumn;
    }

    public void setVirtualColumn(VirtualColumn virtualColumn) {
        this.virtualColumn = virtualColumn;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
    }
}

class VirtualColumn {
    // Add properties and getters/setters for VirtualColumn
}

class Company {
    // Add properties and getters/setters for Company
}