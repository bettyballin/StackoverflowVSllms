import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class EntityKey implements Serializable {
    private String name;
    private int version;

    // No-arg constructor is required by JPA
    public EntityKey() {}

    public EntityKey(String name, int version) {
        this.name = name;
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityKey entityKey = (EntityKey) o;

        if (!name.equals(entityKey.name)) return false;
        return version == entityKey.version;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Integer.hashCode(version);
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        // You can write code here to test the EntityKey class
    }
}