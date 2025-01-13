import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Column;
import org.hibernate.annotations.Type;

@Entity
public class MyEntity_18_18 {
    @Column(columnDefinition = "BIGINT")
    @Type(type = "timestamp")
    private Timestamp myTimestamp;

    // getters and setters

    public static void main(String[] args) {
    }
}