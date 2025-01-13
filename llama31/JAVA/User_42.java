import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Entity
@Entity
public class User_42 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Usage
@Service
public class User_42Service {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public static void main(String[] args) {}
}