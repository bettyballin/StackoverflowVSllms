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

public class JPAEntityManagerConfigurator {
    public static void main(String[] stringArray) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory((String)"myPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.setProperty("toplink.jdbc.batch_size", (Object)100);
    }
}
