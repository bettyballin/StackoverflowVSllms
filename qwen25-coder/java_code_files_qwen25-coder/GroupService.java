import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collection;

public class GroupService {

    public void deleteGroup(EntityManager em, Long groupId) {
        Group group = em.find(Group.class, groupId);
        if (group != null) {
            for (User user : new ArrayList<>(group.getUsers())) { // Use a copy to avoid concurrent modification
                user.removeGroup(group);
                em.merge(user); // Optional: merge user back into the persistence context
            }
            group.setUsers(new HashSet<>()); // Clear the collection if needed
            em.remove(group);
        }
    }

    public static void main(String[] args) {
    }
}

// Additional classes needed to compile

class EntityManager {
    public <T> T find(Class<T> entityClass, Object primaryKey) {
        return null;
    }

    public void merge(Object entity) {
    }

    public void remove(Object entity) {
    }
}

class Group {
    public Collection<User> getUsers() {
        return new ArrayList<>();
    }

    public void setUsers(Collection<User> users) {
    }
}

class User {
    public void removeGroup(Group group) {
    }
}