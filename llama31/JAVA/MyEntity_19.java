import javax.persistence.Column;
import javax.persistence.ColumnTransformer;
import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
public class MyEntity_19_19 {
    @Column(columnDefinition = "BIGINT")
    @ColumnTransformer(
        read = "FROM_UNIXTIME(myTimestamp / 1000)",
        write = "UNIX_TIMESTAMP(?) * 1000"
    )
    private Timestamp myTimestamp;

    // No-arg constructor
    public MyEntity_19() {}

    // Constructor with field initialization
    public MyEntity_19(Timestamp myTimestamp) {
        this.myTimestamp = myTimestamp;
    }

    // Getter
    public Timestamp getMyTimestamp() {
        return myTimestamp;
    }

    // Setter
    public void setMyTimestamp(Timestamp myTimestamp) {
        this.myTimestamp = myTimestamp;
    }

    public static void main(String[] args) {
        // Example usage
        Timestamp now = new Timestamp(System.currentTimeMillis());
        MyEntity_19 entity = new MyEntity_19(now);
        System.out.println(entity.getMyTimestamp());
    }
}