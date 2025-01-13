import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.Column;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Customer_2_2 {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "deleted")
    private Boolean deleted = false;

    @Version
    private Integer version;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public static void main(String[] args) {
    }
}