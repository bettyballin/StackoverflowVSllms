import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserGroupManager {
    private EntityManager em;

    public UserGroupManager(EntityManager em) {
        this.em = em;
    }

    public void removeGroup(Object groupToDelete) {
        Query query = em.createQuery("UPDATE User u SET u.groups = u.groups - :group WHERE :group MEMBER OF u.groups");
        query.setParameter("group", groupToDelete);
        query.executeUpdate();

        // Now you can remove the group
        em.remove(groupToDelete);
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your-persistence-unit");
        EntityManager em = emf.createEntityManager();
        UserGroupManager userGroupManager = new UserGroupManager(em);
        // You need to create or retrieve the groupToDelete object
        // Object groupToDelete = ...;
        // userGroupManager.removeGroup(groupToDelete);
        em.close();
        emf.close();
    }
}