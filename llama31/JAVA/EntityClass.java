import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class EntityClass {
    @Column(name = "LastTouched")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTouched;

    @PrePersist
    @PreUpdate
    public void setLastTouched() {
        this.lastTouched = new Date();
    }
}