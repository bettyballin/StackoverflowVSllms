import java.util.Set;
import java.util.HashSet;

public class GroupManager {
    private EntityManager entityManager = new EntityManager();

    public void remove(final Group group) {
        entityManager.getTransaction().begin(); // If no transaction exists
        final Set<User> users = new HashSet<>(group.getUsers());
        for (User user : users) {
            user.getGroups().remove(group);
        }
        group.setUsers(new HashSet<>());
        entityManager.remove(group);
        entityManager.flush(); // Forces deletion operation to occur immediately in the database even if there are concurrent operations taking place
        entityManager.getTransaction().commit();
    }
    public static void main(String[] args) {
    }
}

class EntityManager {
    public EntityTransaction getTransaction() {
        return new EntityTransaction();
    }

    public void remove(Object obj) {
    }

    public void flush() {
    }
}

class EntityTransaction {
    public void begin() {
    }

    public void commit() {
    }
}

class Group {
    private Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

class User {
    private Set<Group> groups = new HashSet<>();

    public Set<Group> getGroups() {
        return groups;
    }
}