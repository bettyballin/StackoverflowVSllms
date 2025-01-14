import java.lang.String;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Demo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable=false, insertable=true)
    private Date created;

    // Standard getters and setters with conventional names
    public long getId() { return id; }
    public Demo setId(long id) { this.id = id; return this; }

    public String getName() { return name; }
    public Demo setName(String name) { this.name = name; return this; }

    public Date getCreated() {
        if (created == null) return new Date();
        return created;
    } // This is for Java usage and will not affect database behavior

	public static void main(String[] args) {
	}
}