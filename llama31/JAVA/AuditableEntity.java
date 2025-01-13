import java.util.Date;
import javax.persistence.PrePersist;

public class AuditableEntity {
    private Date created;

    @PrePersist
    public void prePersist() {
        if (created == null) {
            created = new Date();
        }
    }

    public static void main(String[] args) {
    }
}