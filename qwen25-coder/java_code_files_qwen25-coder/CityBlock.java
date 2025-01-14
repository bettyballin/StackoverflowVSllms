import java.util.Set;
import java.util.HashSet;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.query.Query;

@Entity
@Table(name = "cityblock")
public class CityBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Existing mapping for ops
    @OneToMany(mappedBy = "cityBlock", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Operation> ops = new HashSet<>();

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Set<Operation> getOps() { return ops; }
    public void setOps(Set<Operation> ops) { this.ops = ops; }

    // Method to get active operations
    @Transient
    public List<Operation> getActiveOps(Session session) {
        String hql = "FROM Operation o WHERE o.cityBlock = :cityBlock AND o.status != 'COMPLETED'";
        return session.createQuery(hql, Operation.class)
                .setParameter("cityBlock", this)
                .list();
    }

    // Method to get completed operations
    @Transient
    public List<Operation> getCompletedOps(Session session) {
        String hql = "FROM Operation o WHERE o.cityBlock = :cityBlock AND o.status = 'COMPLETED'";
        return session.createQuery(hql, Operation.class)
                .setParameter("cityBlock", this)
                .list();
    }
}