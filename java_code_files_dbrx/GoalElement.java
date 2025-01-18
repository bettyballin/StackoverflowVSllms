import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity // Use @javax.persistence.* annotations instead of the older deprecated hibernate versions (https://discourse.hibernate.org/t/migrating-from-hibernate-annotations-to-jpa/790)
public class GoalElement implements Comparable<GoalElement>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // or any suitable strategy for your DB
    private Long id;

    @Column
    private String entry;

    @Temporal(TemporalType.TIMESTAMP) // you can adjust the precision of this timestamp as needed
    @Column(updatable = false, insertable = false)  // disable updating this column for existing rows via Hibernate/JPA
    private Date creationDate;

    public GoalElement() {}

    public String getEntry() { return entry; }
    public void setEntry(String entry){ this.entry = entry; }
    public Date getCreationDate(){ return creationDate; }

    @Override
    public int compareTo(GoalElement other) {
        // Implement ordering logic (e.g., compare by creationDate)
        return this.creationDate.compareTo(other.creationDate);
    }
}