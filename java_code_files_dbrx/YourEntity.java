import java.io.Serializable;
import java.util.Map;

// Dummy annotations and enums to make the code compile
@interface Entity {}
@interface Embeddable {}
@interface OneToMany {
    CascadeType[] cascade() default {};
}
@interface EmbeddedId {}
@interface ManyToOne {}
enum CascadeType {
    ALL
}

@Entity
public class YourEntity {
    // Other fields...

    @OneToMany(cascade = CascadeType.ALL)
    private Map<String, StringChildEntity> mapFieldName;

    // Constructors
    public YourEntity() {}

    // Getters and setters
    public Map<String, StringChildEntity> getMapFieldName() {
        return mapFieldName;
    }

    public void setMapFieldName(Map<String, StringChildEntity> mapFieldName) {
        this.mapFieldName = mapFieldName;
    }
}

@Entity
public class StringParent implements Serializable {
    private static final long serialVersionUID = 1L;

    // Placeholder for StringParent class
    // Include fields and methods as needed

    private Long id; // Example field

    // Constructors
    public StringParent() {}

    public StringParent(Long id) {
        this.id = id;
    }

    // Getters and setters
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof StringParent)) return false;

        StringParent that = (StringParent) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode(){
        return id != null ? id.hashCode() : 0;
    }
}

@Embeddable
public class ChildPK implements Serializable {
    private static final long serialVersionUID = 1L;

    String key;

    @ManyToOne
    StringParent parent;

    // Constructors
    public ChildPK() {
    }

    public ChildPK(String key, StringParent parent) {
        this.key = key;
        this.parent = parent;
    }

    // Getters and setters
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public StringParent getParent() {
        return parent;
    }

    public void setParent(StringParent parent) {
        this.parent = parent;
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChildPK childPK = (ChildPK) o;

        if (key != null ? !key.equals(childPK.key) : childPK.key != null) return false;
        return parent != null ? parent.equals(childPK.parent) : childPK.parent == null;
    }

    // hashCode method
    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }
}

@Entity
public class StringChildEntity {
    @EmbeddedId
    ChildPK id;

    // The actual value of this instance, mapped to 'mapFieldName'.
    private String val;

    // Constructors
    public StringChildEntity() {
    }

    public StringChildEntity(ChildPK id, String val) {
        this.id = id;
        this.val = val;
    }

    // Getters and setters
    public ChildPK getId() {
        return id;
    }

    public void setId(ChildPK id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
        // Method that changes the key should be carefully implemented.
        // If you allow change in a property making part of an Identity
        // then handle with care and reassign it accordingly to another Object
        // if needed or throw error.
    }
}