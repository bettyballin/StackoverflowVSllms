import java.util.List;
import java.util.ArrayList;

public class SearchRulePersistenceManager {
    public static void main(String[] args) {
        // Assuming entityManager is your persistence context instance
        EntityManager entityManager = new EntityManager();
        int indexTemplateId = 1; // Assuming indexTemplateId is already known
        int fieldNumber = 2; // Assuming fieldNumber is already known
        Field field = new Field(); // Assuming field object is properly initialized

        // Create and configure SearchRule
        SearchRule searchRule = new SearchRule();
        searchRule.setName("sampleName");
        searchRule.setThreshold(5);
        searchRule.setTouchedBy("user123");
        
        // Persist the parent object to generate its ID
        entityManager.persist(searchRule);
        entityManager.flush(); // Ensure that ID is generated and available in searchRule
        
        // Create FieldRule with an embedded PK
        FieldRulePK fieldRulePK = new FieldRulePK();
        fieldRulePK.setIndexTemplateId(indexTemplateId); // Assuming indexTemplateId is already known
        fieldRulePK.setFieldNumber(fieldNumber); // Assuming fieldNumber is already known
        fieldRulePK.setSearchRuleId(searchRule.getId()); // Use the generated ID from searchRule
        
        FieldRule fieldRule = new FieldRule();
        fieldRule.setFieldRulePK(fieldRulePK);
        fieldRule.setRuleValue("sampleRuleValue");
        fieldRule.setField(field); // Assuming field object is properly initialized
        
        // Set back reference to parent
        searchRule.getFieldRuleCollection().add(fieldRule);
        
        // Persist the child object
        entityManager.persist(fieldRule);
    }
}

class EntityManager {
    private int idCounter = 1;

    public void persist(Object o) {
        if (o instanceof SearchRule) {
            ((SearchRule) o).setId(idCounter++);
        } else if (o instanceof FieldRule) {
            // Handle FieldRule if necessary
        }
        // Dummy implementation
    }
    public void flush() {
        // Dummy implementation
    }
}

class SearchRule {
    private String name;
    private int threshold;
    private String touchedBy;
    private int id;
    private List<FieldRule> fieldRuleCollection = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }
    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
    public void setTouchedBy(String touchedBy) {
        this.touchedBy = touchedBy;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public List<FieldRule> getFieldRuleCollection() {
        return fieldRuleCollection;
    }
}

class FieldRulePK {
    private int indexTemplateId;
    private int fieldNumber;
    private int searchRuleId;

    public void setIndexTemplateId(int indexTemplateId) {
        this.indexTemplateId = indexTemplateId;
    }
    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }
    public void setSearchRuleId(int searchRuleId) {
        this.searchRuleId = searchRuleId;
    }
}

class FieldRule {
    private FieldRulePK fieldRulePK;
    private String ruleValue;
    private Field field;

    public void setFieldRulePK(FieldRulePK fieldRulePK) {
        this.fieldRulePK = fieldRulePK;
    }
    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }
    public void setField(Field field) {
        this.field = field;
    }
}

class Field {
    // Dummy class
}