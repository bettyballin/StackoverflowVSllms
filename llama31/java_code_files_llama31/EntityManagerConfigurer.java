/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.EntityManager
 *  javax.persistence.EntityManagerFactory
 *  javax.persistence.FlushModeType
 *  javax.persistence.Persistence
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

public class EntityManagerConfigurer {
    public static void main(String[] stringArray) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory((String)"example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.setFlushMode(FlushModeType.COMMIT);
        entityManager.close();
        entityManagerFactory.close();
    }
}
