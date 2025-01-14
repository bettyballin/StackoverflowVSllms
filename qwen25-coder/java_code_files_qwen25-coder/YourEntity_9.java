import java.util.UUID;
import java.util.Arrays;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

// Entity class with GUID as primary key
@Entity
@Table(name = "your_table")
public class YourEntity_9 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // Optional: Existing ID field for backward compatibility
    @Column(unique = true, nullable = false, updatable = false)
    private Long sequenceId;

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Long sequenceId) {
        this.sequenceId = sequenceId;
    }
}

// Hibernate Interceptor to populate GUID for new records
public class YourEntity_9Interceptor extends EmptyInterceptor {
    @Override
    public boolean onSave(
        Object entity,
        Serializable id,
        Object[] state,
        String[] propertyNames,
        Type[] types
    ) {
        if (entity instanceof YourEntity_9) {
            UUID generatedId = UUID.randomUUID();
            int index = Arrays.asList(propertyNames).indexOf("id");
            if (index != -1 && state[index] == null) {
                state[index] = generatedId;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}