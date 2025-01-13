import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
public class MyEntity_15_15 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "is_assigned_id")
    private Boolean isAssignedId;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsAssignedId() {
        return isAssignedId;
    }

    public void setIsAssignedId(Boolean isAssignedId) {
        this.isAssignedId = isAssignedId;
    }

    public static void main(String[] args) {
    }
}