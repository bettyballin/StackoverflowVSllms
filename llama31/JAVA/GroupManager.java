import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GroupManager {
    private EntityManager em;

    public GroupManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit");
        em = emf.createEntityManager();
    }

    public void deleteGroup(Long groupId) {
        Group groupToDelete = em.find(Group.class, groupId);

        // Remove the group from all users
        for (User user : groupToDelete.getUsers()) {
            user.getGroups().remove(groupToDelete);
            em.merge(user); // Update the user
        }

        // Now you can remove the group
        em.getTransaction().begin();
        em.remove(groupToDelete);
        em.getTransaction().commit();
    }

    public static void main(String[] args) {
        GroupManager gm = new GroupManager();
        // Assuming you have a groupId to delete
        gm.deleteGroup(1L);
    }
}

class Group {
    // Assuming you have the necessary fields and getters/setters
    private Long id;
    private String name;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

class User {
    // Assuming you have the necessary fields and getters/setters
    private Long id;
    private String name;
    private List<Group> groups;

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}