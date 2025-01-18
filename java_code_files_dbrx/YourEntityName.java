import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={
   @UniqueConstraint(name="UNIQUE_NAME_VERSION", columnNames={"NAME","VERSION"} )}) // Create unique constraint on database (optional)
public class YourEntityName {
    private CompositeId id;
    // other fields...

    @EmbeddedId
    public CompositeId getId() {
        return id;
    }

    public void setId(CompositeId id) {
        this.id = id;
    }
     // Rest of entity code here including constructors, setters, and other getters.

    public YourEntityName() {
        // Default constructor
    }

    public static void main(String[] args) {
        // Main method implementation
    }

    @Embeddable
    public static class CompositeId implements Serializable {
        // Composite key fields
        private String name;
        private String version;

        // Constructors
        public CompositeId() {
            // Default constructor
        }

        public CompositeId(String name, String version) {
            this.name = name;
            this.version = version;
        }

        // Getters and setters
        @Column(name = "NAME")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Column(name = "VERSION")
        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        // equals and hashCode methods (required for embedded id)
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CompositeId)) return false;

            CompositeId that = (CompositeId) o;

            if (!getName().equals(that.getName())) return false;
            return getVersion().equals(that.getVersion());
        }

        @Override
        public int hashCode() {
            int result = getName().hashCode();
            result = 31 * result + getVersion().hashCode();
            return result;
        }
    }
}