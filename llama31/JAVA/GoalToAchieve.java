import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

@Entity
@Table(name = "GoalToAchieve")
public class GoalToAchieve {
    @CollectionOfElements
    @JoinTable(name = "GoalToAchieve_entry", joinColumns = @JoinColumn(name = "goalToAchieve_id"))
    @Sort(type = SortType.NATURAL)
    private SortedSet<String> entries = new TreeSet<String>();

    @Columns(columns = {
        @Column(name = "element"),
        @Column(name = "timestamp", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    })
    private Object elementAndTimestamp; // Added a field to use the @Columns annotation

    public SortedSet<String> getEntries() {
        return entries;
    }

    public void setEntries(SortedSet<String> entries) {
        this.entries = entries;
    }

    public Object getElementAndTimestamp() {
        return elementAndTimestamp;
    }

    public void setElementAndTimestamp(Object elementAndTimestamp) {
        this.elementAndTimestamp = elementAndTimestamp;
    }
}