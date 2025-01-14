import javax.persistence.*;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
public class GoalToAchieve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @JoinTable(name = "GoalToAchieve_entry", joinColumns = @JoinColumn(name = "goalToAchieve_id"))
    @OrderBy
    private SortedSet<TimestampedString> entries = new TreeSet<>();

    // Getters and setters

    public static void main(String[] args) {
    }
}

@Embeddable
class TimestampedString implements Comparable<TimestampedString> {
    private String value;
    private java.sql.Timestamp timestamp;

    public TimestampedString() {
    }

    public TimestampedString(String value, java.sql.Timestamp timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    // Getters and setters

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public java.sql.Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(java.sql.Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(TimestampedString o) {
        int cmp = this.timestamp.compareTo(o.timestamp);
        if (cmp != 0) return cmp;
        return this.value.compareTo(o.value);
    }
}