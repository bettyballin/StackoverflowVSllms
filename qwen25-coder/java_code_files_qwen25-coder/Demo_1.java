import java.lang.String;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Demo_1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @PrePersist
    protected void onCreate() {
        if (created == null) created = new Date();
    }

    // Standard getters and setters with conventional names
    public long getId() { return id; }
    public Demo_1 setId(long id) { this.id = id; return this; }

    public String getName() { return name; }
    public Demo_1 setName(String name) { this.name = name; return this; }

    public Date getCreated() {
        if (created == null) return new Date();
        return created;
    } // This is for Java usage and will not affect database behavior

    public static void main(String[] args) {
    }
}