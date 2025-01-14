import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import org.hibernate.annotations.Type;
import java.sql.Timestamp;

@Entity
public class MyEntity_5 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type = "com.example.TimestampBigIntType")
    @Column(name = "timestamp_column")
    private Timestamp timestamp;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public static void main(String[] args) {
    }
}