import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SearchRuleDAO {
    private EntityManager entityManager;

    public SearchRuleDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        entityManager = emf.createEntityManager();
    }

    public void persistSearchRule() {
        // Step 1: Persist the SearchRule entity
        SearchRule searchRule = new SearchRule();
        searchRule.setName("Example Rule");
        searchRule.setThreshold(10);
        // Assuming indexTemplateId is defined somewhere
        int indexTemplateId = 1;
        searchRule.setIndexTemplateId(indexTemplateId);
        entityManager.getTransaction().begin();
        entityManager.persist(searchRule);
        entityManager.getTransaction().commit();

        // Step 2: Create the FieldRule entities and set the searchRule field
        FieldRule fieldRule = new FieldRule();
        fieldRule.setRuleValue("Example Value");
        // Assuming field is defined somewhere
        Field field = new Field();
        fieldRule.setField(field);
        fieldRule.setSearchRule(searchRule); // Set the persisted SearchRule entity

        FieldRulePK fieldRulePK = new FieldRulePK();
        fieldRulePK.setIndexTemplateId(indexTemplateId);
        // Assuming fieldNumber is defined somewhere
        int fieldNumber = 1;
        fieldRulePK.setFieldNumber(fieldNumber);
        fieldRulePK.setSearchRuleId(searchRule.getId()); // Set the generated primary key
        fieldRule.setFieldRulePK(fieldRulePK);

        // Step 3: Persist the FieldRule entity
        entityManager.getTransaction().begin();
        entityManager.persist(fieldRule);
        entityManager.getTransaction().commit();
    }

    public static void main(String[] args) {
        SearchRuleDAO dao = new SearchRuleDAO();
        dao.persistSearchRule();
    }
}

class SearchRule {
    private int id;
    private String name;
    private int threshold;
    private int indexTemplateId;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getIndexTemplateId() {
        return indexTemplateId;
    }

    public void setIndexTemplateId(int indexTemplateId) {
        this.indexTemplateId = indexTemplateId;
    }
}

class FieldRule {
    private FieldRulePK fieldRulePK;
    private String ruleValue;
    private Field field;
    private SearchRule searchRule;

    // Getters and setters
    public FieldRulePK getFieldRulePK() {
        return fieldRulePK;
    }

    public void setFieldRulePK(FieldRulePK fieldRulePK) {
        this.fieldRulePK = fieldRulePK;
    }

    public String getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public SearchRule getSearchRule() {
        return searchRule;
    }

    public void setSearchRule(SearchRule searchRule) {
        this.searchRule = searchRule;
    }
}

class FieldRulePK {
    private int indexTemplateId;
    private int fieldNumber;
    private int searchRuleId;

    // Getters and setters
    public int getIndexTemplateId() {
        return indexTemplateId;
    }

    public void setIndexTemplateId(int indexTemplateId) {
        this.indexTemplateId = indexTemplateId;
    }

    public int getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public int getSearchRuleId() {
        return searchRuleId;
    }

    public void setSearchRuleId(int searchRuleId) {
        this.searchRuleId = searchRuleId;
    }
}

class Field {
    // Add fields and methods as necessary
}