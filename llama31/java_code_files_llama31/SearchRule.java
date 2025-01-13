/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Entity
 *  javax.persistence.EntityManager
 *  javax.persistence.PersistenceContext
 *  javax.persistence.PostPersist
 */
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PostPersist;

@Entity
public class SearchRule {
    @PersistenceContext
    private EntityManager entityManager;

    @PostPersist
    public void afterPersist() {
        FieldRule fieldRule = new FieldRule();
        this.entityManager.persist((Object)fieldRule);
    }

    public static void main(String[] stringArray) {
    }
}
