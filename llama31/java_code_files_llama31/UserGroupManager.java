/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.EntityManager
 *  javax.persistence.EntityManagerFactory
 *  javax.persistence.Persistence
 *  javax.persistence.Query
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserGroupManager {
    private EntityManager em;

    public UserGroupManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void removeGroup(Object object) {
        Query query = this.em.createQuery("UPDATE User u SET u.groups = u.groups - :group WHERE :group MEMBER OF u.groups");
        query.setParameter("group", object);
        query.executeUpdate();
        this.em.remove(object);
    }

    public static void main(String[] stringArray) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory((String)"your-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserGroupManager userGroupManager = new UserGroupManager(entityManager);
        entityManager.close();
        entityManagerFactory.close();
    }
}
