import java.util.List;
import java.util.stream.Collectors;

public class SomeClass {
    private SomeDb db;

    public List<SomeEntity> getSomeEntities() {
        return db.getSomeEntities().stream()
            .filter(entity -> isDate(entity.getField1()) && entity.getField2().equals("SomeValue"))
            .collect(Collectors.toList());
    }

    // Assuming isDate and SomeEntity are defined elsewhere
    private boolean isDate(String field) {
        // Implementation to check if the field is a date
        return true; // Replace with actual implementation
    }

    // Assuming SomeDb and SomeEntity are defined elsewhere
    private class SomeDb {
        public List<SomeEntity> getSomeEntities() {
            // Implementation to retrieve some entities
            return null; // Replace with actual implementation
        }
    }

    private class SomeEntity {
        public String getField1() {
            // Implementation to retrieve field 1
            return null; // Replace with actual implementation
        }

        public String getField2() {
            // Implementation to retrieve field 2
            return null; // Replace with actual implementation
        }
    }

    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        List<SomeEntity> someEntities = someClass.getSomeEntities();
        // Process the list of some entities
    }
}