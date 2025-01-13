/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.EntityManager
 *  javax.persistence.EntityManagerFactory
 *  javax.persistence.Persistence
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SearchRuleDAO {
    private EntityManager entityManager;

    public SearchRuleDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory((String)"example-unit");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void persistSearchRule() {
        SearchRule searchRule = new SearchRule();
        searchRule.setName("Example Rule");
        searchRule.setThreshold(10);
        int n = 1;
        searchRule.setIndexTemplateId(n);
        this.entityManager.getTransaction().begin();
        this.entityManager.persist((Object)searchRule);
        this.entityManager.getTransaction().commit();
        FieldRule fieldRule = new FieldRule();
        fieldRule.setRuleValue("Example Value");
        Field field = new Field();
        fieldRule.setField(field);
        fieldRule.setSearchRule(searchRule);
        FieldRulePK fieldRulePK = new FieldRulePK();
        fieldRulePK.setIndexTemplateId(n);
        int n2 = 1;
        fieldRulePK.setFieldNumber(n2);
        fieldRulePK.setSearchRuleId(searchRule.getId());
        fieldRule.setFieldRulePK(fieldRulePK);
        this.entityManager.getTransaction().begin();
        this.entityManager.persist((Object)fieldRule);
        this.entityManager.getTransaction().commit();
    }

    public static void main(String[] stringArray) {
        SearchRuleDAO searchRuleDAO = new SearchRuleDAO();
        searchRuleDAO.persistSearchRule();
    }
}
