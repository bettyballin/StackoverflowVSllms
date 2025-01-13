import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class EntityMetadata {
    @Column(name = "LastTouched", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTouched;

    public static void main(String[] args) {
    }
}