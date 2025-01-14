// OptimisticLockingExample.java

public class OptimisticLockingExample {

    public static void main(String[] args) throws ConflictException {
        int id = 1;
        Entity entity = findEntityById(id);
        int version = entity.getVersion();

        modifyEntity(entity);

        boolean success = updateEntityIfVersionMatches(entity, version);
        if (!success) {
            throw new ConflictException("Data has been changed by another transaction");
        } else {
            System.out.println("Entity updated successfully: " + entity);
        }
    }

    static Entity findEntityById(int id) {
        // Simulate fetching an entity from a database along with its version
        return Database.getEntityById(id);
    }

    static void modifyEntity(Entity entity) {
        // Modify the entity's data
        entity.setData("Modified Data");
    }

    static boolean updateEntityIfVersionMatches(Entity entity, int oldVersion) {
        // Attempt to update the entity if the version matches
        return Database.updateEntityIfVersionMatches(entity, oldVersion);
    }
}

class Entity {
    private int id;
    private String data;
    private int version;

    public Entity(int id, String data, int version) {
        this.id = id;
        this.data = data;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public int getVersion() {
        return version;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    @Override
    public String toString() {
        return "Entity{id=" + id + ", data='" + data + "', version=" + version + "}";
    }
}

class Database {
    // Simulate a simple in-memory database with optimistic locking
    private static Entity storedEntity = new Entity(1, "Initial Data", 1);

    public static Entity getEntityById(int id) {
        // Return a copy to simulate fetching from a database
        if (storedEntity.getId() == id) {
            return new Entity(storedEntity.getId(), storedEntity.getData(), storedEntity.getVersion());
        }
        return null;
    }

    public static boolean updateEntityIfVersionMatches(Entity entity, int oldVersion) {
        // Check if the versions match
        if (storedEntity.getId() == entity.getId() && storedEntity.getVersion() == oldVersion) {
            // Update the entity and increment its version
            storedEntity.setData(entity.getData());
            storedEntity.setVersion(storedEntity.getVersion() + 1);
            return true;
        } else {
            // Version mismatch indicates concurrent modification
            return false;
        }
    }
}

class ConflictException extends Exception {
    public ConflictException(String message) {
        super(message);
    }
}