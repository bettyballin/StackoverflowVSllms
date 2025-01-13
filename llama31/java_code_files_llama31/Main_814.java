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

public class Main_814 {
    public static void main(String[] stringArray) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory((String)"example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Long l = 1L;
        MyEntity myEntity = (MyEntity)entityManager.find(MyEntity.class, (Object)l);
        entityManager.detach((Object)myEntity);
        entityManager.close();
        entityManagerFactory.close();
    }
}
