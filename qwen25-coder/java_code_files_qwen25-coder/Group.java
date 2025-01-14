// Group.java
import java.util.Set;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;

@Entity
public class Group {
    @ManyToMany(mappedBy="groups", cascade = CascadeType.PERSIST)
    Set<User> users;

    // Getter and setter for users
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    
    // Method to remove a user from the group and manage the join table
    public void removeUser(User user) {
        if (users != null && !users.isEmpty()) {
            users.remove(user);
            user.getGroups().remove(this);
        }
    }

    // Additional methods...
}