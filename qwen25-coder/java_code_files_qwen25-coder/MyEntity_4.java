import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;

@Entity
public class MyEntity_4 {
    @EmbeddedId
    private EntityKey id;

    // Other fields, getters, setters...

    public MyEntity_4() {}

    public MyEntity_4(String name, int version) {
        this.id = new EntityKey(name, version);
    }

    // Getters and setters for other fields

    public EntityKey getId() {
        return id;
    }

    public void setId(EntityKey id) {
        this.id = id;
    }

    public static void main(String[] args) {
    }
}

class EntityKey {
    private String name;
    private int version;

    // Constructor
    public EntityKey(String name, int version) {
        this.name = name;
        this.version = version;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getVersion() {
        return version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}