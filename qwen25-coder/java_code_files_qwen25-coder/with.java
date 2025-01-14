import java.lang.String;
public class with {
    // Assuming 'EntityClass' is your entity and 'EntityDto' is your DTO class with similar fields
    EntityManager entityManager = new EntityManager();
    int entityId = 1;

    EntityClass entity = entityManager.find(EntityClass.class, entityId);
    EntityDto entityDto = new EntityDto(entity.getField1(), entity.getField2());
    // Modify the DTO as needed

    public static void main(String[] args) {
    }
}

class EntityManager {
    public <T> T find(Class<T> clazz, int id) {
        // Stub implementation
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}

class EntityClass {
    public String getField1() { return "field1"; }
    public String getField2() { return "field2"; }
}

class EntityDto {
    public EntityDto(String field1, String field2) {
        // Initialize fields as needed
    }
}